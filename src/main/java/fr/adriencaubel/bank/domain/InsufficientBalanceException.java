package fr.adriencaubel.bank.domain;

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message);
	}
}
