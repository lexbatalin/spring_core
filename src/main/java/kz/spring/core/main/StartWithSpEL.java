package kz.spring.core.main;

import kz.spring.core.impls.pool.T1000SpEL;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartWithSpEL {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("core/applicationContext.xml");
        T1000SpEL t1000SpEL = (T1000SpEL) context.getBean("t1000GoldenPool");
        t1000SpEL.beginShow();
    }
}
