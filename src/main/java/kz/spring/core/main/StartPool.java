package kz.spring.core.main;

import kz.spring.core.impls.pool.T1000Pool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartPool {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("core/applicationContext.xml");

        T1000Pool t1000Pool = (T1000Pool) context.getBean("t1000Pool");
        t1000Pool.action();
    }
}
