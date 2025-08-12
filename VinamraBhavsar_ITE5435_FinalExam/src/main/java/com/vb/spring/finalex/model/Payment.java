package com.vb.spring.finalex.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Payment {
    @NotBlank(message = "Method required")   // CARD/CASH/INTERAC
    private String method;

    @NotNull @Min(0)
    private Double amount;

    @NotBlank(message = "Currency required") // CAD
    private String currency;

    // getters/setters
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
}
