package fr.adriencaubel.bank.domain.repository;

import java.util.HashMap;
import java.util.Map;

import fr.adriencaubel.bank.domain.model.CompteBancaire;
import jakarta.ejb.Stateless;

@Stateless
public class FakeCompteBancaireRepository {
	private final Map<String, CompteBancaire> accounts = new HashMap<>();

	public FakeCompteBancaireRepository() {
		accounts.put("FR123456789", new CompteBancaire("FR123456789", 1000.0, "123"));
		accounts.put("FR987654321", new CompteBancaire("FR987654321", 500.0, "456"));
	}

	public CompteBancaire findByIban(String iban) {
		return accounts.get(iban);
	}

	public void save(CompteBancaire account) {
		accounts.put(account.getIban(), account);
	}
}