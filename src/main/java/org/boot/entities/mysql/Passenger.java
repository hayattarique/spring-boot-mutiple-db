package org.boot.entities.mysql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "passengers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Integer passengerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    @Column(name = "travel_date")
    private LocalDate travelDate;
    private String source;
    private String destination;
    private double fare;
}
