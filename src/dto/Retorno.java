package dto;

public class Retorno {
	
	private int status;
	private String descricao;
	private Object data;
	
	
	public Retorno(Status s, Object data) {
		super();
		this.status = s.getStatus();
		this.descricao = s.getDescricao();
		this.data = data;
	}
	
	public Retorno(Status s) {
		this.status = s.getStatus();
		this.descricao = s.getDescricao();
	}
	
	public static Retorno novo(Status s){
		return new Retorno(s);
	}
	
	public static Retorno novo(Status s, Object data){
		return new Retorno(s,data);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
