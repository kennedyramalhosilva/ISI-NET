package model;

import java.util.ArrayList;

public class Publicacao {
	
	private int idPublicacao;
	
	private int idProduto;
	
	private String nomeUsuario;
	
	private Pessoa usuario;
	
	private Produto produto;
	
	private String detalhes;
	
	private String data;
	
	private boolean privacidade = false;
			
	private boolean isDisponivel = true;
	
	private String tipoNegociacao;
	
	private ArrayList <Proposta> propostasRecebidas = new ArrayList<Proposta>();
	
	private Proposta propostaAceita;
	
	private EstadoPublicacao estadoPublicacao = new Valida();

	public EstadoPublicacao getEstadoPublicacao() {
		return estadoPublicacao;
	}

	public void setEstadoPublicacao(EstadoPublicacao estadoPublicacao) {
		this.estadoPublicacao = estadoPublicacao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isDisponivel() {
		return isDisponivel;
	}

	public void setDisponivel(boolean isDisponivel) {
		this.isDisponivel = isDisponivel;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public Pessoa getUsuario() {
		return usuario;
	}

	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}

	public boolean isPrivacidade() {
		return privacidade;
	}

	public void setPrivacidade(boolean privacidade) {
		this.privacidade = privacidade;
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getTipoNegociacao() {
		return tipoNegociacao;
	}

	public void setTipoNegociacao(String tipoNegociacao) {
		this.tipoNegociacao = tipoNegociacao;
	}

	public ArrayList <Proposta> getPropostasRecebidas() {
		return propostasRecebidas;
	}

	public void setPropostasRecebidas(ArrayList <Proposta> propostasRecebidas) {
		this.propostasRecebidas = propostasRecebidas;
	}

	public Proposta getPropostaAceita() {
		return propostaAceita;
	}

	public void setPropostaAceita(Proposta propostaAceita) {
		this.propostaAceita = propostaAceita;
	}

	public int getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
}
