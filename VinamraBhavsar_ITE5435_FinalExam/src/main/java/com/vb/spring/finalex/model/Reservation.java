package com.vb.spring.finalex.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "reservations")
public class Reservation {
    @Id
    private String id;

    @NotBlank(message = "Flight number required")
    private String flightNumber;

    @NotBlank(message = "Origin required")
    private String origin;

    @NotBlank(message = "Destination required")
    private String destination;

    @NotNull(message = "Travel date required")
    @FutureOrPresent(message = "Travel date cannot be in the past")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate travelDate;

    @NotNull @Min(1)
    private Integer seats;

    @Valid @NotNull
    private Customer customer;

    @Valid @NotNull
    private Payment payment;

    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDate getTravelDate() { return travelDate; }
    public void setTravelDate(LocalDate travelDate) { this.travelDate = travelDate; }

    public Integer getSeats() { return seats; }
    public void setSeats(Integer seats) { this.seats = seats; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
}
