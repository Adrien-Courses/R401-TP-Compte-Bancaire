package fr.adriencaubel.bank.application;

import fr.adriencaubel.bank.domain.InsufficientBalanceException;
import fr.adriencaubel.bank.domain.repository.FakeCompteBancaireRepository;
import fr.adriencaubel.bank.domain.repository.FakeTransactionRepository;
import fr.adriencaubel.bank.domain.model.CompteBancaire;
import fr.adriencaubel.bank.domain.model.Transaction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Objects;

@ApplicationScoped
public class CompteBancaireService {

	@Inject
	private FakeCompteBancaireRepository compteBancaireRepository;

	@Inject
	private FakeTransactionRepository transactionRepository;

	public CompteBancaire findByIban(String iban) {
		return compteBancaireRepository.findByIban(iban);
	}

	public void recupererArgent(String iban, double amount) throws InsufficientBalanceException {
		var compte = compteBancaireRepository.findByIban(iban);
		if (compte == null) {
			throw new IllegalArgumentException("Compte non trouvé");
		}
		compte.debiter(amount);
		compteBancaireRepository.save(compte);
	}

	public void transferer(String fromIban, String toIban, double amount) throws InsufficientBalanceException {
		var compteSource = compteBancaireRepository.findByIban(fromIban);
		var compteDestination = compteBancaireRepository.findByIban(toIban);
		
		if (compteSource == null) {
			throw new IllegalArgumentException("Compte source non trouvé");
		}
		if (compteDestination == null) {
			throw new IllegalArgumentException("Compte destination non trouvé");
		}
		
		compteSource.debiter(amount);
		compteDestination.crediter(amount);
		var transaction = new Transaction(fromIban, toIban, amount);
		transactionRepository.save(transaction);
		
		compteBancaireRepository.save(compteSource);
		compteBancaireRepository.save(compteDestination);
	}

	public void configurerDecouvert(String iban, double montantDecouvert) {
		if (montantDecouvert <= 0) {
			throw new IllegalArgumentException("Le découvert autorisé doit être strictement positif");
		}
		
		var compte = compteBancaireRepository.findByIban(iban);
		if (compte == null) {
			throw new IllegalArgumentException("Compte non trouvé");
		}
		
		compte.setDecouvertAutorise(montantDecouvert);
		compteBancaireRepository.save(compte);
	}
}
