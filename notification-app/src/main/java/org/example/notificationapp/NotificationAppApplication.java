package org.example.notificationapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "org.example.notificationapp",
        "org.example.core",
        "org.example.infra"
})
@EntityScan(basePackages = "org.example.infra.entities")
@EnableJpaRepositories(basePackages = "org.example.infra.repositories")
public class NotificationAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationAppApplication.class, args);
    }
}
