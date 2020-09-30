package com.jkishbaugh.polling_app;

import com.jkishbaugh.polling_app.controller.PollController;
import com.jkishbaugh.polling_app.repository.PollRepository;
import com.jkishbaugh.polling_app.services.PollService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.support.GenericApplicationContext;



@SpringBootConfiguration(proxyBeanMethods = false)
@EnableAutoConfiguration
public class PollingAppApplication {

    public static SpringApplication buildApp() {
        return new SpringApplicationBuilder(PollingAppApplication.class)
                .initializers((GenericApplicationContext context) -> {

                    context.registerBean(PollController.class, () -> new PollController(context.getBean(PollService.class)));
                    context.registerBean(PollService.class, PollService::new);


                }).build();
    }

    public static void main(String[] args) {
        buildApp().run(args);
    }

}
