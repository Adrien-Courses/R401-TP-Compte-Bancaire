package fr.adriencaubel.bank.presentation;

import java.util.List;

import fr.adriencaubel.bank.application.TransactionService;
import fr.adriencaubel.bank.domain.model.Transaction;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/transactions")
@RequestScoped
public class TransactionController {

	@Inject
	private TransactionService transactionService;

	@GET
	@Path("{iban}")
	@Produces("application/json")
	public Response getTransactionsByIban(@PathParam("iban") String iban) {
		System.out.println("Received IBAN: " + iban);

		List<Transaction> transactions = transactionService.getHistoriqueByIban(iban);
		System.out.print(transactions);
		return Response.ok(transactions).build();
	}
}