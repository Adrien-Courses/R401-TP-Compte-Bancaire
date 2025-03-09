package fr.adriencaubel.bank.presentation.dto;

public class TransferRequest {
    private String fromIban;
    private String toIban; 
    private double amount;

    public String getFromIban() {
        return fromIban;
    }

    public String getToIban() {
        return toIban;
    }

    public double getAmount() {
        return amount;
    }
}