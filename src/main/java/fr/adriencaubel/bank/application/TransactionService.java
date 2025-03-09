package fr.adriencaubel.bank.application;

import java.util.List;

import fr.adriencaubel.bank.domain.model.Transaction;
import fr.adriencaubel.bank.domain.repository.FakeTransactionRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class TransactionService {

	@Inject
	private FakeTransactionRepository transactionRepository;

	public List<Transaction> getHistoriqueByIban(String iban) {
		return transactionRepository.findByIban(iban);
	}
}
