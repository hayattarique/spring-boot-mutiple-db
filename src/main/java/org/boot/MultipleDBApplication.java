package org.boot;

import lombok.RequiredArgsConstructor;
import org.boot.entities.mysql.Passenger;
import org.boot.entities.postgres.Ticket;
import org.boot.repositories.mysql.PassengerRepository;
import org.boot.repositories.postgres.TicketRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class MultipleDBApplication {
    private final PassengerRepository passengerRepository;
    private final TicketRepository ticketRepository;

    public static void main(String[] args) {
        SpringApplication.run(MultipleDBApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            passengerRepository.save(Passenger.builder()
                    .address("Moghlakhar Nawada")
                    .email("shahanmalick@gmail.com")
                    .phone("7970325605")
                    .name("Sharique imam")
                    .destination("New Delhi")
                    .source("Gaya")
                    .travelDate(LocalDate.of(2024, 7, 20))
                    .fare(1900).build());

            ticketRepository.save(Ticket.builder().bookingDate(LocalDate.now(Clock.systemDefaultZone()))
                    .bookingNumber(UUID.randomUUID().toString()).bookingSource("Paytm")
                    .bookingStatus("Confirmed").paymentType("Debit Card").build());

        };

    }

}
