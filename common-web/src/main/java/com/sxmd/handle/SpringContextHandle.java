package com.sxmd.handle;

import com.sxmd.exception.SxmdException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Description:  spring 上下文工具类
 *
 * @author cy
 * @date 2020年05月28日 15:21
 * Version 1.0
 */

@Component
public class SpringContextHandle implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringContextHandle.applicationContext == null) {
            SpringContextHandle.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext(){
        if(applicationContext == null){
            throw new SxmdException("spring 上下文没有初始化");
        }
        return applicationContext;
    }

    /**
     * Description:   获得bean 对象
     *
     * @param beanName:  bean 名称
     * @return java.lang.Object
     * @author cy
     * @date  2020/5/28 15:31
     */
    public static Object getBean(String beanName){
        return getApplicationContext().getBean(beanName);
    }

    /**
     * Description:   获得bean 对象
     *
     * @param clazz:
     * @return T
     * @author cy
     * @date  2020/5/28 15:33
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * Description:   获得bean 对象
     *
     * @param name:
     * @param clazz:
     * @return T
     * @author cy
     * @date  2020/5/28 15:33
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

}
