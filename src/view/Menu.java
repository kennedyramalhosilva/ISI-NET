package view;

import model.Usuario;

public class Menu {
	
	public void menuInicial(Usuario u) {
		
		System.out.println("\nUsu�rio Conectado: "+u.getNomeUsuario()+"""
					
				O que voc� deseja?
					
				1. Cadastrar Usu�rio;
				2. Realizar Login;
				3. Publica��es;
				4. Cupom;
				5. Amizade;
				6. Buscar perfil;
				7. Logout;
				0. Fechar App;""");
			
	}
	
	public void menuUsuario() {
		System.out.println("""
				
				Como voc� deseja se cadastrar?
				1. Pessoa;
				2. Empresa Parceira;
				0. Sair""");
	}
	
	public void menuLogin() {
		System.out.println("""
				
				Como voc� deseja realizar Login?
				1. Pessoa;
				2. Empresa Parceira;
				0. Sair""");
	}
	
	public void tiposNegociacao() {
		System.out.println("""
				
				Qual tipo de negocia��o voc� deseja realizar?
				1. Troca;
				2. Doa��o;
				3. Empr�stimo""");
	}
	
	public void menuPublicacoes() {
		System.out.println("""
				
				O que voc� deseja ?
				1. Publicar;
				2. Feed;
				3. Minhas publica��es""");
	}
	
	public void menuAmizades() {
		System.out.println("""
				
				O que voc� deseja ?
				1. Meus amigos;
				2. Solicita��es de amizade;""");
	}
	
/*	public static void menuCupom() {
		System.out.println("""
			
			O que voc� deseja ?
			1. Cadastrar Cupom;
			2. Ver meus Cupons;""");
	}*/
}
