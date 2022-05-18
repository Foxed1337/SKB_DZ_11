package ru.zenkov.skb_dz_11;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class SkbDz11Application {

    public static void main(String[] args) {
        SpringApplication.run(SkbDz11Application.class, args);
    }
}
