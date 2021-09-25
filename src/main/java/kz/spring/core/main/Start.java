package kz.spring.core.main;

import kz.spring.core.impls.robots.ModelT1000;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("core/applicationContext.xml");

        ModelT1000 modelT1000 = (ModelT1000) context.getBean("mod1");
        System.out.println(modelT1000);
        modelT1000.action();

        ModelT1000 modelT1001 = (ModelT1000) context.getBean("model1");
        System.out.println(modelT1001);
        modelT1001.action();

//        ModelT1000 modelT1000P = (ModelT1000) context.getBean("t1000Prop");
//        System.out.println(modelT1000P);
//        modelT1000P.action();

        ((ConfigurableApplicationContext) context).close();
    }
}
