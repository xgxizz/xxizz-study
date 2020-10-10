package com.xu.classloader.util;

import com.xu.classloader.anno.ImporterSource;
import com.xu.classloader.testdir.TestService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Importers {

    public static Map<String, TestService> importers = new LinkedHashMap<String,TestService>();

    private static void registryImporter(String src, TestService importer) {
        importers.put(src,importer);
    }

    private static void initImporters() {

        Set<Class<?>> sources = PackageUtil.scan("com.xu.classloader.testdir", ImporterSource.class);
        for(Class<?> clazz : sources) {
            ImporterSource source = clazz.getDeclaredAnnotation(ImporterSource.class);
           // String hdfsFile = HdfsFileHelper.getHdfsFile(source.src());
            try {
                TestService importer = (TestService) clazz.newInstance();
                //importer.setHdfsFile(hdfsFile);
                registryImporter(source.src(),importer);
            }catch (Exception e) {
                System.err.println("注册失败：" + clazz.getSimpleName() );
            }
        }
    }

    static {

        initImporters();
    }

    public static void main(String[] args) {
        importers.keySet().stream().forEach(System.out::println);
        importers.get("TestServiceImpl04").sayHello();
    }
}