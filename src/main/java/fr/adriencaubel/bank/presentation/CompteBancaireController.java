package fr.adriencaubel.bank.presentation;

import fr.adriencaubel.bank.application.CompteBancaireService;
import fr.adriencaubel.bank.domain.InsufficientBalanceException;
import fr.adriencaubel.bank.presentation.dto.CompteDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/comptes")
public class CompteBancaireController {

	@Inject
	private CompteBancaireService compteBancaireService;

	@GET
	@Path("/{iban}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountByIban(@PathParam("iban") String iban) {
		var compte = compteBancaireService.findByIban(iban);
		if (compte == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		var compteDto = new CompteDto(compte.getIban(), compte.getSolde(), compte.getDecouvertAutorise());
		return Response.ok(compteDto).build();
	}

	@POST
	@Path("/recupererArgent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response withdraw(@QueryParam("iban") String iban, @QueryParam("amount") double amount) {
		var compte = compteBancaireService.findByIban(iban);
		if (compte == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		try {
			compteBancaireService.recupererArgent(iban, amount);
			return Response.ok().build();
		} catch (InsufficientBalanceException e) {
			return Response.status(Response.Status.BAD_REQUEST)
						 .entity("Solde insuffisant")
						 .build();
		}
	}

	@POST
	@Path("/transferer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response transfer(TransferRequest request) {
		var fromAccount = compteBancaireService.findByIban(request.getFromIban());
		var toAccount = compteBancaireService.findByIban(request.getToIban());

		if (fromAccount == null || toAccount == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		try {
			compteBancaireService.transferer(request.getFromIban(), request.getToIban(), request.getAmount());
			return Response.ok().build();
		} catch (InsufficientBalanceException e) {
			return Response.status(Response.Status.BAD_REQUEST)
						 .entity("Solde insuffisant")
						 .build();
		}
	}

	@POST
	@Path("/{iban}/decouvert")
	@Produces(MediaType.APPLICATION_JSON)
	public Response configurerDecouvert(
			@PathParam("iban") String iban,
			@QueryParam("limite") double limite) {

		try {
			compteBancaireService.configurerDecouvert(iban, limite);
			return Response.ok().build();
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.BAD_REQUEST)
						 .entity(e.getMessage())
						 .build();
		}
	}
}
