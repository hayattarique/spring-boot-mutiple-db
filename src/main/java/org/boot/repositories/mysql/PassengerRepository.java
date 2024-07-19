package org.boot.repositories.mysql;

import org.boot.entities.mysql.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}
