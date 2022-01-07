package model;

import dao.PublicacaoDAO;

public class Encerrada implements EstadoPublicacao {
	PublicacaoDAO pubDAO = new PublicacaoDAO();
	public Encerrada() {
		
	}	
	@Override
	public void alterarVisibilidade(int CodPubli) {
		pubDAO.editarIsDisponivel(CodPubli, true);

	}

}
