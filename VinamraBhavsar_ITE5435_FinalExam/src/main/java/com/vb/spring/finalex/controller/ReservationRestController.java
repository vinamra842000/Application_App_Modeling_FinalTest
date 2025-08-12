package com.vb.spring.finalex.controller;

import com.vb.spring.finalex.model.Reservation;
import com.vb.spring.finalex.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {

    private final ReservationService service;
    public ReservationRestController(ReservationService service) { this.service = service; }

    // GET all
    @GetMapping
    public List<Reservation> all() { return service.all(); }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> one(@PathVariable String id) {
        Reservation r = service.get(id);
        return r == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(r);
    }

    // SEARCH: /api/reservations/search?origin=YYZ&destination=YVR
    @GetMapping("/search")
    public List<Reservation> search(@RequestParam String origin, @RequestParam String destination) {
        return service.search(origin, destination);
    }

    // CREATE (POST) – Jackson auto‑maps JSON → Reservation
    @PostMapping
    public ResponseEntity<Reservation> create(@Valid @RequestBody Reservation r) {
        return ResponseEntity.ok(service.create(r));
    }

    // UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable String id, @Valid @RequestBody Reservation r) {
        Reservation existing = service.get(id);
        if (existing == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(service.update(id, r));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Reservation existing = service.get(id);
        if (existing == null) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
