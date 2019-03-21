package Entity;

import dto.Retorno;

public class ApiException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private Retorno retorno;

	public ApiException(Retorno retorno) {
		super(retorno.getDescricao());
		this.retorno = retorno;
	}

	public Retorno getRetorno() {
		return retorno;
	}
}
