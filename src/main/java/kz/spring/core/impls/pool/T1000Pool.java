package kz.spring.core.impls.pool;

import kz.spring.core.interfaces.Robot;
import kz.spring.core.interfaces.RobotPool;

import java.util.Collection;

public class T1000Pool implements RobotPool {

    private Collection<Robot> robotCollection;

    public void setRobotCollection(Collection<Robot> robotCollection) {
        this.robotCollection = robotCollection;
    }

    @Override
    public Collection<Robot> getRobotCollection() {
        return robotCollection;
    }

    public void action() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~ Robot pool ~~~~~~~~~~~~~~~~~~~~~~~");
        for (Robot robot: robotCollection) {
            robot.action();
            System.out.println("######### end robot #########");
        }
    }
}
