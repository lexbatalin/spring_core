package kz.spring.aop.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.err.println(bean + " BeforeInitialization!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.err.println(bean + " AfterInitialization!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return bean;
    }
}
