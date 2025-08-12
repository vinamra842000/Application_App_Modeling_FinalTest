package com.vb.spring.finalex.controller;

import com.vb.spring.finalex.model.Customer;
import com.vb.spring.finalex.model.Payment;
import com.vb.spring.finalex.model.Reservation;
import com.vb.spring.finalex.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationWebController {

    private final ReservationService service;
    public ReservationWebController(ReservationService service) { this.service = service; }

    // Show form
    @GetMapping("/")
    public String showForm(Model model) {
        Reservation r = new Reservation();
        r.setCustomer(new Customer());
        r.setPayment(new Payment());
        model.addAttribute("reservation", r);
        return "reservation_form";
    }

    // Handle submit
    @PostMapping("/reserve")
    public String submit(@Valid @ModelAttribute("reservation") Reservation r,
                         BindingResult errors,
                         Model model) {
        if (errors.hasErrors()) {
            return "reservation_form";
        }
        Reservation saved = service.create(r);
        model.addAttribute("reservation", saved);
        return "reservation_success";
    }
}
