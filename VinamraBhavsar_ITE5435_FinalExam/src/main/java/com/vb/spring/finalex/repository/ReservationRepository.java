package com.vb.spring.finalex.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vb.spring.finalex.model.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
    List<Reservation> findByOriginAndDestination(String origin, String destination);
    List<Reservation> findByCustomerEmail(String email);
}
