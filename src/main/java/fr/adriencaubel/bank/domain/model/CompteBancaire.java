package fr.adriencaubel.bank.domain.model;

public class CompteBancaire {
	private final String iban;
	private double balance;
	private String motDePasse;

	public CompteBancaire(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}