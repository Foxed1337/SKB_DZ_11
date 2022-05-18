package ru.zenkov.skb_dz_11.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;


@Component
@Endpoint(id = "my-metrics")
public class MyActuatorEndpoint {
    private final Map<String, Map<String, String>> features = new LinkedHashMap<>();


    @PostConstruct
    public void initFeatures() {

        features.put("Метрики для http://localhost:8080/some-get-req", new LinkedHashMap<>() {
            {
                put("Кол-во запросов", "http://localhost:8080/actuator/metrics/my.count.get.req");
                put("Время запроса", "http://localhost:8080/actuator/metrics/my.time.get.req");
            }
        });

        features.put("Метрики для http://localhost:8080/some-post-req", new LinkedHashMap<>() {
            {
                put("Кол-во запросов", "http://localhost:8080/actuator/metrics/my.count.post.req");
                put("Время запроса", "http://localhost:8080/actuator/metrics/my.time.post.req");
            }
        });

        features.put("Метрики для http://localhost:8080/heavy-business-logic", new LinkedHashMap<>() {
            {
                put("Кол-во запросов", "http://localhost:8080/actuator/metrics/my.count.heavy.req");
                put("Время запроса", "http://localhost:8080/actuator/metrics/my.time.heavy.req");
            }
        });

        features.put("Метрики для http://localhost:8080/user-login", new LinkedHashMap<>() {
            {
                put("Кол-во пользователей онлайн", "http://localhost:8080/actuator/metrics/my.user.online");
            }
        });
    }

    @ReadOperation
    public Map<String, Map<String, String>> getFeatures() {
        return features;
    }
}
