package kz.spring.core.main;

import kz.spring.core.impls.pool.T1000Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartPoolMap {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("core/applicationContext.xml");

        T1000Map t1000Map = (T1000Map) context.getBean("t1000Map");

        t1000Map.action();
    }
}
