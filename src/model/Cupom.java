package model;

public class Cupom {
	
	private int idCupom;
		
	private String validade;
	
	private boolean isValid = true;
	
	private double valor;
	
	private String descricao;
	
	private String EmpresaParceira_nomeUsuario;
	
	private String Pessoa_nomeUsuario;
	
	private EmpresaParceira empresa;
	
	private Pessoa pessoa;
	
	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String emitirCupom(Produto p) {return null;}


	public EmpresaParceira getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaParceira empresa) {
		this.empresa = empresa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getIdCupom() {
		return idCupom;
	}

	public void setIdCupom(int idCupom) {
		this.idCupom = idCupom;
	}

	public String getEmpresaParceira_nomeUsuario() {
		return EmpresaParceira_nomeUsuario;
	}

	public void setEmpresaParceira_nomeUsuario(String empresaParceira_nomeUsuario) {
		EmpresaParceira_nomeUsuario = empresaParceira_nomeUsuario;
	}

	public String getPessoa_nomeUsuario() {
		return Pessoa_nomeUsuario;
	}

	public void setPessoa_nomeUsuario(String pessoa_nomeUsuario) {
		Pessoa_nomeUsuario = pessoa_nomeUsuario;
	}
	
	
}
