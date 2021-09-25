package kz.spring.aop.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@Aspect
public class MyLogger {

//    @Pointcut("execution(* kz.spring.aop.objects.FileManager.*(..)) && within(kz.spring.aop.objects.*)")
    @Pointcut("execution(* kz.spring.aop.objects.Manager.*(..))")
    private void allMethods() {}

    @Pointcut("@annotation(kz.spring.aop.annotation.ShowResult)")
    private void annotateShowResult() {}

    @Pointcut("@annotation(kz.spring.aop.annotation.ShowTime)")
    private void annotateShowTime() {}

    @Before(value = "allMethods()")
    public void init() {
        System.out.println("init");
    }

    @After(value = "allMethods()")
    public void close() {
        System.out.println("close");
    }

    @AfterThrowing(pointcut = "allMethods()")
    public void error() {
        System.out.println("error");
    }

//    @Around("allMethods() && annotateShowTime()")
    @Around("allMethods()")
    public Object watchTime(ProceedingJoinPoint joinPoint) {
        long start = System.currentTimeMillis();
        System.out.println("method begin: " + joinPoint.getSignature().toShortString());
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        long delta = System.currentTimeMillis() - start;
        System.out.println("method end: " + joinPoint.getSignature().toShortString() + " time: " + delta + " ms.");

        return obj;
    }

//    @AfterReturning(pointcut = "allMethods() && annotateShowResult()", returning = "obj")
    @AfterReturning(pointcut = "allMethods() && execution(java.util.Set *(String)) && args(folder))", returning = "obj")
    public void printInfoSet(Object obj, String folder) {

        System.out.println("Print set info >>>>>>>>>>>>>>>>>>");
        System.out.println("Folder: " + folder);
        Set tmp = (Set) obj;
        for (Object o: tmp) {
            System.out.println(o);
        }
        System.out.println("End set info <<<<<<<<<<<<<<<<<<<<<");

    }

    @AfterReturning(pointcut = "allMethods() && execution(java.util.Map *(String)) && args(folder)", returning = "obj")
    public void printInfoMap(Object obj, String folder) {

        System.out.println("Print map info >>>>>>>>>>>>>>>>>>");
        System.out.println("Folder: " + folder);
        Map tmp = (Map) obj;
        for (Object o: tmp.keySet()) {
            System.out.println("Key: " + o + " Value: " + tmp.get(o));
        }
        System.out.println("End set info <<<<<<<<<<<<<<<<<<<<<");
    }
}
