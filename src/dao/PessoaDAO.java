package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pessoa;

public class PessoaDAO {
	
	Conexao conexao = new Conexao();
	
	public void insere(Pessoa p) {		
		try {
			// cria um preparedStatement
			String sql = "insert into pessoa (nomeUsuario,cpf,nome,email,senha) values (?,?,?,?,?)";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, p.getNomeUsuario());
			stmt.setString(2, p.getCpf());
			stmt.setString(3, p.getNome());
			stmt.setString(4, p.getEmail());
			stmt.setString(5, p.getSenha());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pessoa> consulta() {

		PreparedStatement stmt;
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		try {
			stmt = conexao.getConn().prepareStatement("select * from pessoa");
		
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				Pessoa pessoa = new Pessoa();
				pessoa.setNomeUsuario(rs.getString("nomeUsuario"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setSenha(rs.getString("senha"));
				// adicionando o objeto lista
				pessoas.add(pessoa);
			}
			rs.close();
			stmt.close();
			//conexao.getConn().close();
		} catch (SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		return pessoas;
		
	}
	
}
