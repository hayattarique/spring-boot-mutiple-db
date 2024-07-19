package org.boot.entities.postgres;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tickets")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;
    @Column(name = "booking_no")
    private String bookingNumber;
    @Column(name = "booking_dt")
    private LocalDate bookingDate;
    @Column(name = "booking_status")
    private String bookingStatus;
    @Column(name = "payment_type")
    private String paymentType;
    @Column(name = "booking_source")
    private String bookingSource;
}
