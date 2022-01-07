package view;

import model.Usuario;

public class Menu {
	
	public void menuInicial(Usuario u) {
		
		System.out.println("\nUsuário Conectado: "+u.getNomeUsuario()+"""
					
				O que você deseja?
					
				1. Cadastrar Usuário;
				2. Realizar Login;
				3. Publicações;
				4. Cupom;
				5. Amizade;
				6. Buscar perfil;
				7. Logout;
				0. Fechar App;""");
			
	}
	
	public void menuUsuario() {
		System.out.println("""
				
				Como você deseja se cadastrar?
				1. Pessoa;
				2. Empresa Parceira;
				0. Sair""");
	}
	
	public void menuLogin() {
		System.out.println("""
				
				Como você deseja realizar Login?
				1. Pessoa;
				2. Empresa Parceira;
				0. Sair""");
	}
	
	public void tiposNegociacao() {
		System.out.println("""
				
				Qual tipo de negociação você deseja realizar?
				1. Troca;
				2. Doação;
				3. Empréstimo""");
	}
	
	public void menuPublicacoes() {
		System.out.println("""
				
				O que você deseja ?
				1. Publicar;
				2. Feed;
				3. Minhas publicações""");
	}
	
	public void menuAmizades() {
		System.out.println("""
				
				O que você deseja ?
				1. Meus amigos;
				2. Solicitações de amizade;""");
	}
	
/*	public static void menuCupom() {
		System.out.println("""
			
			O que você deseja ?
			1. Cadastrar Cupom;
			2. Ver meus Cupons;""");
	}*/
}
