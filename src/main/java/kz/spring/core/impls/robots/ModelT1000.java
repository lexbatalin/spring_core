package kz.spring.core.impls.robots;

import kz.spring.core.interfaces.Hand;
import kz.spring.core.interfaces.Head;
import kz.spring.core.interfaces.Leg;
import kz.spring.core.interfaces.Robot;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component("model1")
public class ModelT1000 extends BaseModel implements Robot, InitializingBean, DisposableBean {

    private String color;
    private int year;
    private boolean soundEnabled;

    public ModelT1000() {
    }

    @Bean("mod1")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ModelT1000 model1Bean() {
        return new ModelT1000();
    }

    public ModelT1000(Hand hand, Leg leg, Head head, String color, int year, boolean soundEnabled) {
        super(hand, leg, head);
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    public ModelT1000(String color, int year, boolean soundEnabled) {
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    @Override
    public void action() {
        if (nonNull(getHead())) {
            getHead().calc();
        }
        if (nonNull(getHand())) {
            getHand().catchSomething();
        }
        if (nonNull(getLeg())) {
            getLeg().go();
        }
        System.out.println("My color is: " + color);
        System.out.println("My year is: " + year);
        System.out.println("Can play sound: " + soundEnabled);
    }

    @Override
    public void dance() {
        System.out.println("T1000 is dancing!");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init initialize bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }
}
