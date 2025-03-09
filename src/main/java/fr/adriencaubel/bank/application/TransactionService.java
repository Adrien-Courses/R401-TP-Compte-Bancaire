package fr.adriencaubel.bank.application;

import java.time.LocalDate;
import java.util.List;

import fr.adriencaubel.bank.domain.model.Transaction;
import fr.adriencaubel.bank.domain.model.TransactionSummary;
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

	private List<Transaction> getHistoriqueByIbanAndDate(String iban, LocalDate depuis) {
		return transactionRepository.findByIbanAndDateAfter(iban, depuis);
	}

	public TransactionSummary getTransactionSummary(String iban, LocalDate depuis) {
		List<Transaction> transactions;
		if (depuis != null) {
			transactions = getHistoriqueByIbanAndDate(iban, depuis);
		} else {
			transactions = getHistoriqueByIban(iban);
		}

		double totalEntrant = transactions.stream()
			.filter(t -> t.getToIban().equals(iban))
			.mapToDouble(Transaction::getMontant)
			.sum();

		double totalSortant = transactions.stream()
			.filter(t -> t.getFromIban().equals(iban))
			.mapToDouble(Transaction::getMontant)
			.sum();

		return new TransactionSummary(transactions, totalEntrant, totalSortant);
	}
}