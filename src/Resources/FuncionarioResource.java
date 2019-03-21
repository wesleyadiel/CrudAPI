package Resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Entity.ApiException;
import Entity.Funcionario;
import controller.FuncionarioController;
import dto.Retorno;
import dto.Status;


@Produces("application/json")
@Consumes("application/json")
@Path("funcionario")
public class FuncionarioResource {
	
	@Inject
	private FuncionarioController funcionarioController;
	
	@POST
	@Path("salvar")
	public Response salvar(@Context HttpHeaders headers, Funcionario funcionario) throws ApiException {
		Response response = null;
		try {
			funcionarioController.salvar(funcionario);
			
			response  = Response.ok(new Retorno(Status.SUCESSO)).build();

			return response;
		} catch (ApiException e) {
			throw e;
		}	
	}
	
	@GET
	@Path("deletar/{id}")
	public Response deletar(@Context HttpHeaders headers, @PathParam("id") Long id) throws ApiException {
		Response response = null;
		try {
			funcionarioController.delete(id);
			
			response  = Response.ok(new Retorno(Status.SUCESSO)).build();

			return response;
		} catch (ApiException e) {
			response = Response.ok(e.getRetorno()).build();
		}
		return response;	
	}
	
	@GET
	@Path("buscar")
	public Response buscar(@Context HttpHeaders headers) throws ApiException {
		Response response = null;
		try {
			List<Funcionario> all = new ArrayList<>();
			
			all = funcionarioController.getAll();
			
			response  = Response.ok(new Retorno(Status.SUCESSO, all)).build();

			return response;
		} catch (ApiException e) {
			response = Response.ok(e.getRetorno()).build();
		}
		return null;	
	}
	
	@GET
	@Path("buscar/{id}")
	public Response buscarOne(@Context HttpHeaders headers, @PathParam("id") Long id) throws ApiException {
		Response response = null;
		try {
			Funcionario funcionario = new Funcionario();
			
			funcionario = funcionarioController.getById(id);
			
			response  = Response.ok(new Retorno(Status.SUCESSO, funcionario)).build();

			return response;
		} catch (ApiException e) {
			response = Response.ok(e.getRetorno()).build();
		}
		return response;	
	}
}


