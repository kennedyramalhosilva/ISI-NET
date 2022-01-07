package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;
import model.Publicacao;

public class ProdutoDAO {
	
	Conexao conexao = new Conexao();
	
	public void insere(Produto p) {		
		try {
			// cria um preparedStatement
			String sql = "insert into produto (idProduto,estado,tipoProduto,descricao) values (?,?,?,?)";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setInt(1, p.getIdProduto());
			stmt.setString(2, p.getEstado());
			stmt.setString(3, p.getTipoProduto());
			stmt.setString(4, p.getDescricao());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Produto> consulta() {

		PreparedStatement stmt;
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		try {
			stmt = conexao.getConn().prepareStatement("select * from produto");
		
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				Produto produto = new Produto();
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setEstado(rs.getString("estado"));
				produto.setTipoProduto(rs.getString("tipoProduto"));
				produto.setDescricao(rs.getString("descricao"));
				// adicionando o objeto lista
				produtos.add(produto);
			}
			rs.close();
			stmt.close();
			//conexao.getConn().close();
		} catch (SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		return produtos;
		
	}
	
	public void editarEstado(Produto p, String s) {		
		try {
			// cria um preparedStatement
			String sql = "update produto set estado = ? where idProduto = ?";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, s);
			stmt.setInt(2, p.getIdProduto());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarTipoProduto(Produto p, String s) {		
		try {
			// cria um preparedStatement
			String sql = "update produto set tipoProduto = ? where idProduto = ?";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, s);
			stmt.setInt(2, p.getIdProduto());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarDescricao(Produto p, String s) {		
		try {
			// cria um preparedStatement
			String sql = "update produto set descricao = ? where idProduto = ?";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, s);
			stmt.setInt(2, p.getIdProduto());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
