package kz.spring.core.main;

import kz.spring.core.interfaces.Robot;
import kz.spring.core.interfaces.RobotConveyor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartConveyor {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("core/applicationContext.xml");

        RobotConveyor robotConveyor = (RobotConveyor) context.getBean("t1000Conveyor");

        Robot terminator1 = robotConveyor.createRobot();
        Robot terminator2 = robotConveyor.createRobot();
        Robot terminator3 = robotConveyor.createRobot();

        System.out.println("terminator: " + terminator1);
        System.out.println("terminator: " + terminator2);
        System.out.println("terminator: " + terminator3);
    }
}
