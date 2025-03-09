package fr.adriencaubel.bank.presentation.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionDto {
    private String fromIban;
    private String toIban;
    private double montant;
    private LocalDate date;

    public TransactionDto(String fromIban, String toIban, double montant, LocalDate date) {
        this.fromIban = fromIban;
        this.toIban = toIban;
        this.montant = montant;
        this.date = date;
    }

    public String getFromIban() { return fromIban; }
    public String getToIban() { return toIban; }
    public double getMontant() { return montant; }
    public LocalDate getDate() { return date; }
} 