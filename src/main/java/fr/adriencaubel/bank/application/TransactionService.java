package fr.adriencaubel.bank.application;

import java.util.List;

import fr.adriencaubel.bank.domain.model.Transaction;
import fr.adriencaubel.bank.domain.repository.FakeTransactionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TransactionService {

	@Inject
	private FakeTransactionRepository transactionRepository;

	public List<Transaction> getHistoriqueByIban(String iban) {
		return transactionRepository.findByIban(iban);
	}
}
