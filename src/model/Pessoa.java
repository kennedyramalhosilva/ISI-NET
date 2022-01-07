package model;

import java.util.ArrayList;

public class Pessoa extends Usuario {
	
	private String cpf;
	
	private String nome;
		
	private ArrayList <Pessoa> amigos = new ArrayList<Pessoa>();
	
	private ArrayList <Pessoa> solicitacoesAmizade = new ArrayList<Pessoa>();

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Pessoa> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArrayList<Pessoa> amigos) {
		this.amigos = amigos;
	}

	public ArrayList<Pessoa> getSolicitacoesAmizade() {
		return solicitacoesAmizade;
	}

	public void setSolicitacoesAmizade(ArrayList<Pessoa> solicitacoesAmizade) {
		this.solicitacoesAmizade = solicitacoesAmizade;
	}
	
	public void addAmigo(Pessoa p) {
		this.amigos.add(p);
	}
	
	public void addSolicitacaoAmizade(Pessoa p) {
		this.solicitacoesAmizade.add(p);
	}

}
