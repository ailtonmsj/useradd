package br.com.ailtonmsj.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.ailtonmsj.dto.Usuario;
import br.com.ailtonmsj.service.UsuarioService;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private UsuarioService usuarioService;

    @POST
    public Response add(Usuario usuario) {
    	
    	log.info("Adding Usuario" + usuario);
    	
    	// Check if the required field
    	if (usuario.getNome() == null)
    		return Response.status(HttpStatus.SC_BAD_REQUEST).build();
    	
    	Usuario usuarioDB = usuarioService.get(usuario.getNome());
    	log.debug("usuarioDB" + usuarioDB);
    	
    	// Check if the usuario already exists
    	if (usuarioDB.getNome() != null) {
    		return Response.status(428).build();
    	}		
    		
    	usuarioDB = usuarioService.add(usuario);
    	
    	log.info("Usuario added" + usuario);
    	return Response.ok(usuarioDB).build();
    }
}