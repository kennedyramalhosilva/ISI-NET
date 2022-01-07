package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Amizade;
import model.SolicitacaoAmizade;

public class AmizadeDAO {
	
	Conexao conexao = new Conexao();
	
	public void insere(Amizade a) {		
		try {
			// cria um preparedStatement
			String sql = "insert into amizade (Pessoa_nomeUsuario,Pessoa_nomeUsuario1) values (?,?)";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores

			stmt.setString(1, a.getNomeUsuario());
			stmt.setString(2, a.getNomeUsuario1());

			stmt.execute(); // COLOCA NO BANCO
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Amizade> consulta() {

		PreparedStatement stmt;
		
		ArrayList<Amizade> amizades = new ArrayList<Amizade>();
		
		try {
			stmt = conexao.getConn().prepareStatement("select * from amizade");
		
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				Amizade amizade = new Amizade();
				amizade.setNomeUsuario(rs.getString("Pessoa_nomeUsuario"));
				amizade.setNomeUsuario1(rs.getString("Pessoa_nomeUsuario1"));
				amizades.add(amizade);
			}
			rs.close();
			stmt.close();
			//conexao.getConn().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return amizades;
		
	}
	
	public void excluir(Amizade a) {		
		try {
			// cria um preparedStatement
			String sql = "delete from amizade where pessoa_nomeusuario1 = ?";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, a.getNomeUsuario1());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
