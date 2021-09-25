package kz.spring.core.impls.pool;

import kz.spring.core.interfaces.Robot;
import kz.spring.core.interfaces.RobotPool;

import java.util.Collection;

public class T1000SpEL implements RobotPool {

    private Collection<Robot> robotCollection;

    public T1000SpEL(Collection<Robot> robotCollection) {
        this.robotCollection = robotCollection;
    }

    @Override
    public Collection<Robot> getRobotCollection() {
        return null;
    }

    public void beginShow() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~ Show starts now! ~~~~~~~~~~~~~~~~~~~~");
        for (Robot robot: robotCollection) {
            robot.action();
        }
    }
}
