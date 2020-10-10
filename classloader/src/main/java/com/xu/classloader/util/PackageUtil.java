package com.xu.classloader.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PackageUtil {
    /**
     * 从包package中获取所有的Class
     *
     * @param pack
     * @return
     */
    public static Set<Class<?>> scan(String pack, Class annotation) {

        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();

        boolean recursive = true;
        String packageName = pack;
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);

            while (dirs.hasMoreElements()) {
                URL url = dirs.nextElement();
                String protocol = url.getProtocol();
                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes,annotation);
                } else if ("jar".equals(protocol)) {
                    findAndAddClassesInPackageByJar(classes, recursive, packageName, url,annotation);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }



    private static void findAndAddClassesInPackageByJar(Set<Class<?>> classes, boolean recursive, String packageName, URL url,Class annotation) {
        String packageDirName = packageName.replace('.', '/');
        JarFile jar;
        try {
            jar = ((JarURLConnection) url.openConnection()).getJarFile();

            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                if (name.charAt(0) == '/') {
                    name = name.substring(1);
                }
                if (name.startsWith(packageDirName)) {
                    int idx = name.lastIndexOf('/');
                    if(idx != -1) {
                        packageName = name.substring(0, idx).replace('/', '.');
                    }
                    if((idx != -1) || recursive) {
                        if (name.endsWith(".class") && !entry.isDirectory()) {
                            String className = name.substring(packageName.length() + 1, name.length() - 6);
                            try {
                                Class clazz = Class.forName(packageName + '.' + className);
                                if(clazz.getDeclaredAnnotation(annotation) != null) {
                                    classes.add(clazz);
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 以文件的形式来获取包下的所有Class
     *
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     */
    public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes, Class annotation) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        File[] dirfiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });
        for (File file : dirfiles) {
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes,annotation);
            } else {
                String className = file.getName().substring(0, file.getName().length() - 6);

                try {
                    Class clazz = Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className);
                    if(clazz.getDeclaredAnnotation(annotation) != null) {
                        classes.add(clazz);
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}