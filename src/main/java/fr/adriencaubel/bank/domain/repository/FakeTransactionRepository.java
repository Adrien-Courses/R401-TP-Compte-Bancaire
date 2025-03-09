package fr.adriencaubel.bank.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.adriencaubel.bank.domain.model.Transaction;
import jakarta.ejb.Stateless;

@Stateless
public class FakeTransactionRepository {
	private final List<Transaction> transactions = new ArrayList<>();

	public FakeTransactionRepository() {
		transactions.add(new Transaction("FR123456789", "FR987654321", 1.0));
	}

	public void save(Transaction transaction) {
		transactions.add(transaction);
	}

	public List<Transaction> findByIban(String iban) {
		return transactions.stream().filter(t -> iban.equals(t.getFromIban()) || iban.equals(t.getToIban()))
				.collect(Collectors.toList());
	}
}
