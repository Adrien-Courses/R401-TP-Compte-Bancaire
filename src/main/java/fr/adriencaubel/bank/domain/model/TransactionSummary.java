package fr.adriencaubel.bank.domain.model;

import java.util.List;

public class TransactionSummary {
    private final List<Transaction> transactions;
    private final double totalEntrant;
    private final double totalSortant;

    public TransactionSummary(List<Transaction> transactions, double totalEntrant, double totalSortant) {
        this.transactions = transactions;
        this.totalEntrant = totalEntrant;
        this.totalSortant = totalSortant;
    }

    public List<Transaction> getTransactions() { return transactions; }
    public double getTotalEntrant() { return totalEntrant; }
    public double getTotalSortant() { return totalSortant; }
}