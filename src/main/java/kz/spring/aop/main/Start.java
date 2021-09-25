package kz.spring.aop.main;

import kz.spring.aop.objects.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/applicationContext.xml");
        SomeService someService = (SomeService) context.getBean("someService");
//        int err = someService.getError();
        double val = someService.getDoubleValue();
    }
}
