package org.smart4j.chapter3.init;

import org.smart4j.chapter3.helper.BeanHelper;
import org.smart4j.chapter3.helper.ClassHelper;
import org.smart4j.chapter3.helper.ControllerHelper;
import org.smart4j.chapter3.helper.IocHelper;
import org.smart4j.chapter3.util.ClassUtil;

/**
 * 初始化容器
 */
public final class HelperLoader {

    public static void init(){
        Class<?>[] classArray = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> cls:classArray){
            ClassUtil.loadClass(cls.getName(),true);
        }
    }

}
