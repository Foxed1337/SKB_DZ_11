package ru.zenkov.skb_dz_11.services;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Counter counter;

    @Scheduled(fixedDelay = 1500)
    public void userLoggedIn() {
        counter.increment();
    }

    public UserService(SimpleMeterRegistry registry) {
        this.counter = Counter
                .builder("my.user.online")
                .description("Shows the number of online users")
                .register(registry);
    }

}
