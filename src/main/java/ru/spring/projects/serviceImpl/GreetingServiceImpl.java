package ru.spring.projects.serviceImpl;

import ru.spring.projects.service.GreetingService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;

public class GreetingServiceImpl implements GreetingService {

    private ApplicationContext context;

    @Required
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public String sayGreeting() {
        return "Greeting, user!";
    }
}
