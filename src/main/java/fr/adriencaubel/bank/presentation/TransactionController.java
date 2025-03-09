package fr.adriencaubel.bank.presentation;

import java.time.LocalDate;
import java.util.stream.Collectors;

import fr.adriencaubel.bank.application.TransactionService;
import fr.adriencaubel.bank.presentation.dto.TransactionDto;
import fr.adriencaubel.bank.presentation.dto.TransactionSummaryDto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/transactions")
@RequestScoped
public class TransactionController {

	@Inject
	private TransactionService transactionService;

	@GET
	@Path("{iban}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsByIban(
			@PathParam("iban") String iban,
			@QueryParam("depuis") String depuisStr) {
		
		try {
			LocalDate depuis = depuisStr != null ? LocalDate.parse(depuisStr) : null;
			var summary = transactionService.getTransactionSummary(iban, depuis);
			
			var transactionsDto = summary.getTransactions().stream()
				.map(t -> new TransactionDto(t.getFromIban(), t.getToIban(), t.getMontant(), t.getDate()))
				.collect(Collectors.toList());
			
			var summaryDto = new TransactionSummaryDto(
				transactionsDto,
				summary.getTotalEntrant(),
				summary.getTotalSortant()
			);
			
			return Response.ok(summaryDto).build();
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.BAD_REQUEST)
						 .entity("Format de date invalide. Utilisez le format ISO (ex: 2024-03-09)")
						 .build();
		}
	}
}