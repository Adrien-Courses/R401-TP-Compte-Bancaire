package fr.adriencaubel.bank.presentation;

import fr.adriencaubel.bank.application.CompteBancaireService;
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
		return null;
	}

	@POST
	@Path("/recupererArgent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response withdraw(@QueryParam("iban") String iban, @QueryParam("amount") double amount) {
		return null;
	}

	@POST
	@Path("/transferer")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response transfer(TransferRequest request) {
		return null;
	}
}
