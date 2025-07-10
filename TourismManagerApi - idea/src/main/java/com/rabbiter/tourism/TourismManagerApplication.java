package com.rabbiter.tourism;

import com.rabbiter.tourism.handle.StartupExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.rabbiter.*")
@ComponentScan("com.rabbiter")
@MapperScan("com.**.mapper")
public class tTourismManagerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TourismManagerApplication.class);
        application.addListeners(new StartupExceptionHandler());
        application.run(args);
    }

}
