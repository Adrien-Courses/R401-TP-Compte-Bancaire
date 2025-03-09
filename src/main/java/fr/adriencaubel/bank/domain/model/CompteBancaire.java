package fr.adriencaubel.bank.domain.model;

import fr.adriencaubel.bank.domain.InsufficientBalanceException;

public class CompteBancaire {
	private String iban;
	private double solde;
	private String motDePasse;
	private double decouvertAutorise;

	public CompteBancaire(String iban, double soldeInitial, String motDePasse) {
		this.iban = iban;
		this.solde = soldeInitial;
		this.motDePasse = motDePasse;
		this.decouvertAutorise = 0.0; // Par défaut, pas de découvert
	}

	public void debiter(double montant) throws InsufficientBalanceException {
		if (solde - montant < -decouvertAutorise) {
			throw new InsufficientBalanceException("Solde insuffisant (découvert autorisé dépassé)");
		}
		solde -= montant;
	}

	public void crediter(double montant) {
		solde += montant;
	}

	public void setDecouvertAutorise(double montant) {
		if (montant <= 0) {
			throw new IllegalArgumentException("Le découvert autorisé doit être strictement positif");
		}
		this.decouvertAutorise = montant;
	}

	public String getIban() {
		return iban;
	}

	public double getSolde() {
		return solde;
	}

	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}