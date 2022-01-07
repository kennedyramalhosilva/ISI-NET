package model;

import dao.PublicacaoDAO;

public class Valida implements EstadoPublicacao {
	
	PublicacaoDAO pubDAO = new PublicacaoDAO();
	
	public Valida() {
		
	}
	
	public void alterarVisibilidade(int codPubli) {
		pubDAO.editarIsDisponivel(codPubli, false);
		
	}
}
