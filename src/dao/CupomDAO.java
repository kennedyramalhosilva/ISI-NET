package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cupom;

public class CupomDAO {
	
	Conexao conexao = new Conexao();
	
	public void insere(Cupom c) {		
		try {
			// cria um preparedStatement
			String sql = "insert into cupom (idCupom,validade,isValid,valor,descricao,EmpresaParceira_nomeUsuario,Pessoa_nomeUsuario) values (?,?,?,?,?,?,?)";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setInt(1, c.getIdCupom());
			stmt.setString(2, c.getValidade());
			stmt.setBoolean(3, c.isValid());
			stmt.setDouble(4, c.getValor());
			stmt.setString(5, c.getDescricao());
			stmt.setString(6, c.getEmpresaParceira_nomeUsuario());
			stmt.setString(7, c.getPessoa_nomeUsuario());

			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Cupom> consulta() {

		PreparedStatement stmt;
		
		ArrayList<Cupom> cupons = new ArrayList<Cupom>();
		
		try {
			stmt = conexao.getConn().prepareStatement("select * from cupom");
		
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				Cupom cupom = new Cupom();
				cupom.setIdCupom(rs.getInt("idCupom"));
				cupom.setValidade(rs.getString("validade"));
				cupom.setValid(rs.getBoolean("isValid"));
				cupom.setValor(rs.getDouble("valor"));
				cupom.setDescricao(rs.getString("descricao"));
				cupom.setEmpresaParceira_nomeUsuario(rs.getString("EmpresaParceira_nomeUsuario"));
				cupom.setPessoa_nomeUsuario(rs.getString("Pessoa_nomeUsuario"));
				cupons.add(cupom);
			}
			rs.close();
			stmt.close();
			//conexao.getConn().close();
		} catch (SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		return cupons;
		
	}

}
