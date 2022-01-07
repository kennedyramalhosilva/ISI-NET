package model;

public class EmpresaParceira extends Usuario {
	
	private String cnpj;
	
	private String razaoSocial;
	
	private String nomeFantasia;

	public EmpresaParceira() {}
	
	public EmpresaParceira(String usu, String email, String senha, String cnpj, String razaoSocial, String nomeFantasia) {
		super();
		this.nomeUsuario = usu;
		this.email = email;
		this.senha = senha;
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	

}
