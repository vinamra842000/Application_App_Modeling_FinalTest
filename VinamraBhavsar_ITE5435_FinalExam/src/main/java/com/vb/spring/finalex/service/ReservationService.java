package com.vb.spring.finalex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vb.spring.finalex.model.Reservation;
import com.vb.spring.finalex.repository.ReservationRepository;

@Service
public class ReservationService {
    private final ReservationRepository repo;

    public ReservationService(ReservationRepository repo) {
        this.repo = repo;
    }

    public Reservation create(Reservation r) {
        return repo.save(r);
    }

    // Avoid setId on the incoming object; merge into the existing entity
    public Reservation update(String id, Reservation r) {
        return repo.findById(id).map(existing -> {
            existing.setFlightNumber(r.getFlightNumber());
            existing.setOrigin(r.getOrigin());
            existing.setDestination(r.getDestination());
            existing.setTravelDate(r.getTravelDate());
            existing.setSeats(r.getSeats());
            existing.setCustomer(r.getCustomer());
            existing.setPayment(r.getPayment());
            return repo.save(existing);
        }).orElse(null);
    }

    public List<Reservation> all() { return repo.findAll(); }

    public Reservation get(String id) { return repo.findById(id).orElse(null); }

    public void delete(String id) { repo.deleteById(id); }

    public List<Reservation> search(String origin, String destination) {
        return repo.findByOriginAndDestination(origin, destination);
    }
}
