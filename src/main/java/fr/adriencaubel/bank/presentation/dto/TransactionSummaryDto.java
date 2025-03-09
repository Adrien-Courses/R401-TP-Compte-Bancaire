package fr.adriencaubel.bank.presentation.dto;

import java.util.List;

public class TransactionSummaryDto {
    private List<TransactionDto> transactions;
    private double totalEntrant;
    private double totalSortant;

    public TransactionSummaryDto(List<TransactionDto> transactions, double totalEntrant, double totalSortant) {
        this.transactions = transactions;
        this.totalEntrant = totalEntrant;
        this.totalSortant = totalSortant;
    }

    public List<TransactionDto> getTransactions() { return transactions; }
    public double getTotalEntrant() { return totalEntrant; }
    public double getTotalSortant() { return totalSortant; }
} 