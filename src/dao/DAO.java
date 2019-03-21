package dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entity.ApiException;
import Entity.ORM;
import dto.Retorno;
import dto.Status;

public class DAO <Orm extends ORM> {
	
	@PersistenceContext
	EntityManager manager;
	
	public DAO() {
		
	}
	
	public DAO(Class<Orm> clazz, String table) {
		this(clazz,table,"");
	}
	public DAO(Class<Orm> clazz, String table, String tableNative) {
		super();
		this.clazz = clazz;
		this.table = table;
		this.setTableNative(tableNative);
	}

	private Class<Orm> clazz;
	private String table;
	private String tableNative;

	public Class<Orm> getClazz() {
		return clazz;
	}

	public void setClazz(Class<Orm> clazz) {
		this.clazz = clazz;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getTableNative() {
		return tableNative;
	}
	public void setTableNative(String tableNative) {
		this.tableNative = tableNative;
	}
	
	public void salvar(Orm o) throws ApiException  {

		if ((o.getId() != null) && (o.getId() > 0)) {
			update(o);
		} else {
			insert(o);
		}

	}

	public void insert(Orm o) throws ApiException  {

		try {
			manager.persist(o);
			manager.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(new Retorno(Status.FALHA_SALVAR));
		}
	}

	public void update(Orm o) throws ApiException {

		try {
			manager.merge(o);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(new Retorno(Status.FALHA_SALVAR));
		}
	}

	public Orm getById(Long id) throws ApiException {

		try {

			Orm o = manager.find(getClazz(), id);
			return o;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(new Retorno(Status.FALHA_BUSCAR));
		}
	}

	public void remove(Orm o) throws ApiException {
		remove(o.getId());
	}
	
	public void removeById(Long id) throws ApiException {
		remove(id);
	}
	
	public void remove(Long id) throws ApiException {

		try {

			Orm item = manager.find(getClazz(), id);
			manager.remove(item);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ApiException(new Retorno(Status.FALHA_REMOVER));
		}
	}
	
	

}
