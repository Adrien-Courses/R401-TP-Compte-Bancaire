package fr.adriencaubel.hello;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHello() {
		return """
				{
					"message": "Hello from JAX-RS!"
				}
				""";
	}
}
