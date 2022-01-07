package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Encerrada;
import model.Pessoa;
import model.Produto;
import model.Publicacao;
import model.Valida;

public class PublicacaoDAO {
	
	Conexao conexao = new Conexao();
	
	public void insere(Publicacao p) {		
		try {
			// cria um preparedStatement
			String sql = "insert into publicacao (idPublicacao,detalhes,data,privacidade,isDisponivel,tiponegociacao,produto_idProduto,pessoa_nomeUsuario) values (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setInt(1, p.getIdPublicacao());
			stmt.setString(2, p.getDetalhes());
			stmt.setString(3, p.getData());
			stmt.setBoolean(4, p.isPrivacidade());
			stmt.setBoolean(5, p.isDisponivel());
			stmt.setString(6, p.getTipoNegociacao());
			stmt.setInt(7, p.getIdProduto());
			stmt.setString(8, p.getNomeUsuario());

			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Publicacao> consulta() {

		PreparedStatement stmt;
		
		ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();
		
		try {
			stmt = conexao.getConn().prepareStatement("select * from publicacao");
		
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				Publicacao publicacao = new Publicacao();
				PessoaDAO p = new PessoaDAO();
				Pessoa pessoa = new Pessoa();
				ProdutoDAO prod = new ProdutoDAO();
				Produto produto = new Produto();

				
				for(Pessoa pessoa1: p.consulta()) {
					if(pessoa1.getNomeUsuario() == rs.getString("Pessoa_nomeUsuario")) pessoa = pessoa1;
				}
				
				for(Produto produto1: prod.consulta()) {
					if(produto1.getIdProduto() == rs.getInt("Produto_idProduto")) produto = produto1;
				}
				
				publicacao.setIdPublicacao(rs.getInt("idPublicacao"));
				publicacao.setDetalhes(rs.getString("detalhes"));
				publicacao.setData(rs.getString("data"));
				publicacao.setPrivacidade(rs.getBoolean("privacidade"));
				publicacao.setDisponivel(rs.getBoolean("isDisponivel"));
				if (publicacao.isDisponivel() == true) {
					publicacao.setEstadoPublicacao(new Valida());
				} else {
					publicacao.setEstadoPublicacao(new Encerrada());
				}
				publicacao.setTipoNegociacao(rs.getString("tipoNegociacao"));
				publicacao.setIdProduto(rs.getInt("Produto_idProduto"));
				publicacao.setProduto(produto);
				publicacao.setNomeUsuario(rs.getString("Pessoa_nomeUsuario"));
				publicacao.setUsuario(pessoa);
				
				// adicionando o objeto lista
				publicacoes.add(publicacao);
			}
			rs.close();
			stmt.close();
			//conexao.getConn().close();
		} catch (SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		return publicacoes;
		
	}
	
	public void editarIsDisponivel(int codPubli, boolean b) {		
		try {
			// cria um preparedStatement
			String sql = "update publicacao set isDisponivel = ? where idPublicacao = ?";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setBoolean(1, b);
			stmt.setInt(2, codPubli);
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editarTipoNegociacao(Publicacao p, String tipoNegociacao) {		
		try {
			// cria um preparedStatement
			String sql = "update publicacao set tipoNegociacao = ? where idPublicacao = ?";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, tipoNegociacao);
			stmt.setInt(2, p.getIdPublicacao());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Publicacao p) {		
		try {
			// cria um preparedStatement
			String sql = "delete from publicacao where idPublicacao = ?";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setInt(1, p.getIdPublicacao());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
