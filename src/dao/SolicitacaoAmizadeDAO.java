package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SolicitacaoAmizade;

public class SolicitacaoAmizadeDAO {

	Conexao conexao = new Conexao();

	public void insere(SolicitacaoAmizade s) {
		try {
			// cria um preparedStatement
			String sql = "insert into solicitacoesamizade (Pessoa_nomeUsuario,Pessoa_nomeUsuario1) values (?,?)";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores

			stmt.setString(1, s.getNomeUsuario());
			stmt.setString(2, s.getNomeUsuario1());

			stmt.execute(); // COLOCA NO BANCO
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<SolicitacaoAmizade> consulta() {

		PreparedStatement stmt;

		ArrayList<SolicitacaoAmizade> solicitacoes = new ArrayList<SolicitacaoAmizade>();

		try {
			stmt = conexao.getConn().prepareStatement("select * from solicitacoesamizade");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				SolicitacaoAmizade solicitacao = new SolicitacaoAmizade();
				solicitacao.setNomeUsuario(rs.getString("Pessoa_nomeUsuario"));
				solicitacao.setNomeUsuario1(rs.getString("Pessoa_nomeUsuario1"));
				solicitacoes.add(solicitacao);
			}
			rs.close();
			stmt.close();
			// conexao.getConn().close();
		} catch (SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		return solicitacoes;

	}
	
	public void excluir(SolicitacaoAmizade s) {		
		try {
			// cria um preparedStatement
			String sql = "delete from solicitacoesamizade where pessoa_nomeusuario1 = ?";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, s.getNomeUsuario1());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
