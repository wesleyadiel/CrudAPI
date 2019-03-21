package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import Entity.ApiException;
import Entity.Funcionario;
import dto.Retorno;
import dto.Status;

@Stateless
public class FuncionarioDAO extends DAO<Funcionario> {

	public FuncionarioDAO() {
		super(Funcionario.class, "funcionario");
	}	
	
	public List<Funcionario> getAll() throws ApiException {
		List<Funcionario> all;
		try {
			String sql = "SELECT f FROM Funcionario f";
			TypedQuery<Funcionario> query = manager.createQuery(sql, Funcionario.class);
	
			all = query.getResultList();
			
			return all;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new ApiException(new Retorno(Status.FALHA_BUSCAR));
		}
	}
	
}