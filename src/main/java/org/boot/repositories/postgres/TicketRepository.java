package org.boot.repositories.postgres;

import org.boot.entities.postgres.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
