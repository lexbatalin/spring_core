package kz.spring.aop.objects;

import org.springframework.stereotype.Component;

@Component
public class SomeService {

    public int getIntValue() {
        return 5;
    }

    public double getDoubleValue() {
        return 5.6d;
    }

    public int getError() {
        return 5/0;
    }
}
