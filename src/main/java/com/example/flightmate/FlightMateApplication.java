package com.example.flightmate;

import com.example.flightmate.models.Flight;
import com.example.flightmate.models.FlightStatus;
import com.example.flightmate.models.Seat;
import com.example.flightmate.models.SeatClass;
import com.example.flightmate.repositories.FlightRepository;
import com.example.flightmate.repositories.SeatRepository;
import com.example.flightmate.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EnableJpaAuditing
@SpringBootApplication
public class FlightMateApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightMateApplication.class, args);
    }

    @Bean
    CommandLineRunner testDatabase(UserRepository usersRepository, FlightRepository flightRepository,
                                   SeatRepository seatRepository){
        return args -> {
//            User janKowalski = new User("Jan", "Kowalski", "JK@gmail.com", "Password");
//            usersRepository.save(janKowalski);
//            Thread.sleep(1000);
//            janKowalski.setEmail("JKv2@gmail.com");
//            usersRepository.save(janKowalski);


            Flight flight = new Flight("A01", "WAW", "KRK",
                    LocalDateTime.of(2025, 12, 01, 12, 30, 01),
                    LocalDateTime.of(2025, 12, 01, 13, 30, 01),
                    new BigDecimal("125.00"), FlightStatus.PLANNED);

            flightRepository.save(flight);
            for (int i=0; i < 26; i++){
                for (int n = 0; n < 8; n++) {
                    Seat seat = new Seat(flight, (char) ('A' + i) + String.valueOf(n+1), SeatClass.ECONOMY, true);
                    seatRepository.save(seat);
                }
            }
        };
    }
}
