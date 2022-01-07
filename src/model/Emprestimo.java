package model;

public class Emprestimo {
	
	private String dataDevolucao; 
	
	private Publicacao publicacao;
	
	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public void alterarDataDevoucao(String data) {
		this.dataDevolucao = data;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}
	
}
