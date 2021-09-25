package kz.spring.core.impls.replacement;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class ReplacementT1000 implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Replacement T1000~~~~~~~~~~");
        return o;
    }
}
