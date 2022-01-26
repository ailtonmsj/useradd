package br.com.ailtonmsj.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    public Usuario add(Usuario usuario) {
    	
    	log.info("adicionando usuário" + usuario);
    	
    	Usuario usuarioDB = usuarioService.get(usuario.getNome());
    	
    	if (usuarioDB == null || usuarioDB.getNome() == null)
    		return usuarioService.add(usuario);
    	
    	return null;
    }
}