package br.com.ailtonmsj.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GET
    public Response hello() {
    	
    	log.info("Inicio Hello");
    	
    	// Alguma logica 
    	
    	log.info("Fim Hello");
    	
    	return Response.ok("Request efetuada com sucesso").build();
    }
}