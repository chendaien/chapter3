package org.smart4j.chapter3.helper;

import org.smart4j.chapter3.annotation.Controller;
import org.smart4j.chapter3.annotation.Service;
import org.smart4j.chapter3.constant.ConfigConstant;
import org.smart4j.chapter3.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手类
 */
public final class ClassHelper {

    /**
     * 定义类集合(用于存放所加载的类)
     */
    private static final Set<Class<?>> CLASS_SET ;

    static {
        String appBasePackage = ConfigConstant.APP_BASE_PACKAGE.getStatusMsg();
        CLASS_SET = ClassUtil.getClassSet(appBasePackage);
    }

    /**
     * 获取应用包名下的所有类
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有Service类
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> serviceClassSet = new HashSet<Class<?>>();
        for (Class<?> cls:CLASS_SET) {
            if(cls.isAnnotationPresent(Service.class)){
                serviceClassSet.add(cls);
            }
        }
        return serviceClassSet;
    }

    /**
     * 获取应用包名下所有Controller类
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> controllerClassSet = new HashSet<Class<?>>();
        for (Class<?> cls:CLASS_SET) {
            if(cls.isAnnotationPresent(Controller.class)){
                controllerClassSet.add(cls);
            }
        }
        return controllerClassSet;
    }

    /**
     * 获取应用包名下所有的bean
     */
    public static  Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }
}
