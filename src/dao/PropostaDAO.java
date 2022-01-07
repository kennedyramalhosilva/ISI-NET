package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Proposta;



public class PropostaDAO {
	
	Conexao conexao = new Conexao();
	
	public void insere(Proposta p) {		
		try {
			// cria um preparedStatement
			String sql = "insert into proposta (idProposta,data,tipoProposta,descricao,Publicacao_idPublicacao,Pessoa_nomeUsuario) values (?,?,?,?,?,?)";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setInt(1, p.getIdProposta());
			stmt.setString(2, p.getData());
			stmt.setString(3, p.getTipoProposta());
			stmt.setString(4, p.getDescricao());
			stmt.setInt(5, p.getPublicacao_idPublicacao());
			stmt.setString(6, p.getPessoa_nomeUsuario());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Proposta> consulta() {

		PreparedStatement stmt;
		
		ArrayList<Proposta> propostas = new ArrayList<Proposta>();
		
		try {
			stmt = conexao.getConn().prepareStatement("select * from proposta");
		
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto
				Proposta proposta = new Proposta();
				
				proposta.setIdProposta(rs.getInt("idProposta"));
				proposta.setData(rs.getString("data"));
				proposta.setTipoProposta(rs.getString("tipoProposta"));
				proposta.setDescricao(rs.getString("descricao"));
				proposta.setPublicacao_idPublicacao(rs.getInt("Publicacao_idPublicacao"));
				proposta.setPessoa_nomeUsuario(rs.getString("Pessoa_nomeUsuario"));
				
				// adicionando o objeto lista
				propostas.add(proposta);
			}
			rs.close();
			stmt.close();
			//conexao.getConn().close();
		} catch (SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		return propostas;
		
	}

}
