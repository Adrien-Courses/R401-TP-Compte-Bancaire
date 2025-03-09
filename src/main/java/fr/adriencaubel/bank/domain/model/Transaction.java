package fr.adriencaubel.bank.domain.model;

import java.time.LocalDateTime;

public class Transaction {
	private final String fromIban;
	private final String toIban;
	private final double montant;
	private final LocalDateTime timestamp;

	public Transaction(String fromIban, String toIban, double montant) {
		this.fromIban = fromIban;
		this.toIban = toIban;
		this.montant = montant;
		this.timestamp = LocalDateTime.now();
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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
