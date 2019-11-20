package com.xu.study.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description Bean和Map的相互转换
 * @Author xgx
 * @Date 2019/11/19 10:09
 */
public class BeanMapConverter {

    public static Object MapToBean(Class type, Map map) throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {

        //获取类属性
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        //创建Bean对象
        Object obj = type.newInstance();
        //给Bean对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor: propertyDescriptors) {
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName)) {
                Object value = map.get(propertyName);
                Object arg = value;
                descriptor.getWriteMethod().invoke(obj, arg);
            }
        }
        return obj;

    }
    public static Map BeanToMap(Object bean) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        //获取类属性
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());

        //新建用于返回的Bean对象
        Map map = new HashMap();
        //获取Bean对象的属性和值
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor: propertyDescriptors) {
            if (!descriptor.getName().equals("class")) {
                Object result = descriptor.getReadMethod().invoke(bean, new Object[]{});
                map.put(descriptor.getName(), result);
            }
        }
        return map;
    }
//
//    public static void main(String[] args) throws InvocationTargetException, IntrospectionException, InstantiationException, IllegalAccessException {
//        Map map = new HashMap();
//        map.put("userName","xuguoxing");
//        map.put("age",23);
//        User user = (User) MapToBean(User.class, map);
//        System.out.println(user);
//
//        Map resultMap = BeanToMap(user);
//        System.out.println(resultMap);
//    }
}
