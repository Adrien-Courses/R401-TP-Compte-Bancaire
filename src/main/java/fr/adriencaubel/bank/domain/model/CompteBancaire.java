package fr.adriencaubel.bank.domain.model;

public class CompteBancaire {
	private final String iban;
	private double solde;
	private String motDePasse;

	public CompteBancaire(String iban, double solde, String motDePasse) {
		this.iban = iban;
		this.solde = solde;
		this.motDePasse = motDePasse;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
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