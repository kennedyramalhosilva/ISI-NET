package model;

public class Proposta {
	
	private int idProposta;

	private Pessoa solicitante;

	private String data;

	private String tipoProposta;
	
	private String descricao;
	
	private int Publicacao_idPublicacao;
	
	private String Pessoa_nomeUsuario;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipoProposta() {
		return tipoProposta;
	}

	public void setTipoProposta(String tipoProposta) {
		this.tipoProposta = tipoProposta;
	}

	public Pessoa getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(int idProposta) {
		this.idProposta = idProposta;
	}

	public int getPublicacao_idPublicacao() {
		return Publicacao_idPublicacao;
	}

	public void setPublicacao_idPublicacao(int publicacao_idPublicacao) {
		Publicacao_idPublicacao = publicacao_idPublicacao;
	}

	public String getPessoa_nomeUsuario() {
		return Pessoa_nomeUsuario;
	}

	public void setPessoa_nomeUsuario(String pessoa_nomeUsuario) {
		Pessoa_nomeUsuario = pessoa_nomeUsuario;
	}

}
