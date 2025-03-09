package fr.adriencaubel.bank.domain.model;

import java.time.LocalDate;

public class Transaction {
	private String fromIban;
	private String toIban;
	private double montant;
	private LocalDate date;

	public Transaction(String fromIban, String toIban, double montant) {
		this.fromIban = fromIban;
		this.toIban = toIban;
		this.montant = montant;
		this.date = LocalDate.now();
	}

	public String getFromIban() {
		return fromIban;
	}

	public String getToIban() {
		return toIban;
	}

	public double getMontant() {
		return montant;
	}

	public LocalDate getDate() {
		return date;
	}
}
