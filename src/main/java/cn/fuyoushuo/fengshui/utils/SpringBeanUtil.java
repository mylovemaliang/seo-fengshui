package cn.fuyoushuo.fengshui.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author maliang
 * @Time 15-1-15 上午10:50
 */
@Component
public final class SpringBeanUtil implements ApplicationContextAware {

    private final static Logger logger = LoggerFactory.getLogger(SpringBeanUtil.class);

    private static ApplicationContext ctx;


    /**
     * 通过spring配置文件中配置的bean id取得bean对象
     *
     * @param id spring bean ID值
     * @return spring bean对象
     */
    public static Object getBean(String id) {
        if (ctx == null) {
            throw new NullPointerException("ApplicationContext is null");
        }
        Object obj = null;
        try {
            obj = ctx.getBean(id);
        }catch (NoSuchBeanDefinitionException e){
            logger.error(e.getMessage(), e);
        }
        return obj;
    }

    /**
     * 通过spring配置文件中配置的bean id取得bean对象
     *
     * @param clazz bean class
     * @return spring bean对象
     */
    public static <T> T getBean(Class<T> clazz) {
        if (ctx == null) {
            throw new NullPointerException("ApplicationContext is null");
        }
        T obj = null;
        try {
            obj = ctx.getBean(clazz);
        }catch (NoSuchBeanDefinitionException e){
            logger.error(e.getMessage(), e);
        }
        return obj;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationcontext)
            throws BeansException {
        ctx = applicationcontext;
    }

}
