package fr.adriencaubel.bank.application;

import fr.adriencaubel.bank.domain.InsufficientBalanceException;
import fr.adriencaubel.bank.domain.repository.FakeCompteBancaireRepository;
import fr.adriencaubel.bank.domain.repository.FakeTransactionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CompteBancaireService {

	@Inject
	private FakeCompteBancaireRepository compteBancaireRepository;

	@Inject
	private FakeTransactionRepository transactionRepository;

	public void recupererArgent(String iban, double amount) throws InsufficientBalanceException {

	}

	public void transferer(String fromIban, String toIban, double amount) throws InsufficientBalanceException {

	}
}
