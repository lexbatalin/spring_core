package ru.spring.projects;

import ru.spring.projects.service.GreetingService;
import ru.spring.projects.serviceImpl.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
@ComponentScan
public class LessonsConfiguration {

    @Bean
    @Description("Текстовое описание бина greetingService")
    GreetingService greetingService() {
        return new GreetingServiceImpl();
    }
}
