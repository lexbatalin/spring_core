package kz.spring.core.main;

import kz.spring.core.impls.robots.ModelT1000;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartReplacement {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("core/applicationContext.xml");

        ModelT1000 modelT1000E = (ModelT1000) context.getBean("t1000Empty");
        System.out.println(modelT1000E);
        modelT1000E.dance();

        ModelT1000 modelT1000 = (ModelT1000) context.getBean("t1000");
        System.out.println(modelT1000);
        modelT1000.dance();

        ((ConfigurableApplicationContext) context).close();
    }
}
