package kz.spring.core.impls.pool;

import kz.spring.core.interfaces.RoboPoolMap;
import kz.spring.core.interfaces.Robot;

import java.util.Map;

public class T1000Map implements RoboPoolMap {

    Map<String, Robot> robotCollection;

    public T1000Map(Map<String, Robot> robotCollection) {
        super();
        this.robotCollection = robotCollection;
    }

    @Override
    public Map<String, Robot> getRobotMap() {
        return robotCollection;
    }

    public void action() {
        for(Map.Entry<String, Robot> entry : robotCollection.entrySet()) {
            System.out.println("Robot key is: " + entry.getKey() + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            entry.getValue().action();
        }
    }
}
