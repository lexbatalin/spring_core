package kz.spring.core.impls.conveyor;

import kz.spring.core.interfaces.Robot;
import kz.spring.core.interfaces.RobotConveyor;

public abstract class T1000Conveyor implements RobotConveyor {

    @Override
    public abstract Robot createRobot();
}
