package dto;

public enum Status {

	SUCESSO( 0, "Sucesso!"), 
	FALHA_SALVAR( 1, "Falha ao salvar!"), 
	FALHA_BUSCAR( 2, "Falha ao buscar!"), 
	FALHA( 3, "Falha!"),
	FALHA_REMOVER(4, "Falha ao remover!"),
	;

	private final int status;
	private final String descricao;

	private Status(int status, String descricao) {
		this.status = status;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getStatus() {
		return status;
	}
}