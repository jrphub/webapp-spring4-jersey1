package org.geobricks.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.geobricks.core.HelloWorldCore;
import org.springframework.stereotype.Component;

@Path("/hello")
@Component
public class HelloWorldREST {
	
	//@Autowire
	//private HelloWorldCore hwc;

	@GET
	@Path("{name}")
	public Response sayHello(@PathParam("name") String name) {

		/* Load core library. */
		// Injesting through Autowiring/Inject has some issue, so instatitating
		// explicitly
		HelloWorldCore hwc = new HelloWorldCore();

		/* Stream result */
		return Response.status(200).entity(hwc.sayHello(name)).build();

	}

	@GET
	@Path("json/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayHelloJSON(@PathParam("name") String name) {

		/* Load core library. */
		// Injesting through Autowiring/Inject has some issue, so instatitating
		// explicitly
		HelloWorldCore hwc = new HelloWorldCore();

		/* Stream result */
		return Response.status(200).entity(hwc.sayHelloJSON(name)).build();

	}

}