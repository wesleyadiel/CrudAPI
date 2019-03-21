package controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Entity.ApiException;
import Entity.Funcionario;
import dao.FuncionarioDAO;

@Stateless
public class FuncionarioController {
	
	@Inject
	private FuncionarioDAO dao;
	
	public void salvar(Funcionario funcionario) throws ApiException {
		dao.salvar(funcionario);
	}
	
	public void delete(Long id) throws ApiException {
		dao.remove(id);
	}
	
	public List<Funcionario> getAll() throws ApiException{
		return dao.getAll();
	}
	
	public Funcionario getById(Long id) throws ApiException {
		return dao.getById(id);
	}

}
