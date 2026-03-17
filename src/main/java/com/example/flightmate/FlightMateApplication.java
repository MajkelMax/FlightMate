package com.example.flightmate;

import com.example.flightmate.models.User;
import com.example.flightmate.repositories.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FlightMateApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightMateApplication.class, args);
    }

    @Bean
    CommandLineRunner testDatabase(UsersRepository usersRepository){
        return args -> {
            User janKowalski = new User("Jan", "Kowalski", "JK@gmail.com", "Password");
            usersRepository.save(janKowalski);
            Thread.sleep(1000);
            janKowalski.setEmail("JKv2@gmail.com");
            usersRepository.save(janKowalski);
        };
    }
}
