package fr.adriencaubel.bank.presentation.dto;

public class CompteDto {
    private String iban;
    private double solde;
    private double decouvertAutorise;

    public CompteDto(String iban, double solde, double decouvertAutorise) {
        this.iban = iban;
        this.solde = solde;
        this.decouvertAutorise = decouvertAutorise;
    }

    public String getIban() { return iban; }
    public double getSolde() { return solde; }
    public double getDecouvertAutorise() { return decouvertAutorise; }
} 