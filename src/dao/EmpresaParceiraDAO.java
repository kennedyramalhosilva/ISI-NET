package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.EmpresaParceira;

public class EmpresaParceiraDAO {
	
	Conexao conexao = new Conexao();
	
	public void insere(EmpresaParceira emp) {		
		try {
			// cria um preparedStatement
			String sql = "insert into empresaparceira (nomeUsuario,cnpj,razaoSocial,nomeFantasia,email,senha) values (?,?,?,?,?,?)";
			PreparedStatement stmt = conexao.getConn().prepareStatement(sql);
			// preenche os valores
			stmt.setString(1, emp.getNomeUsuario());
			stmt.setString(2, emp.getCnpj());
			stmt.setString(3, emp.getRazaoSocial());
			stmt.setString(4, emp.getNomeFantasia());
			stmt.setString(5, emp.getEmail());
			stmt.setString(6, emp.getSenha());
			
			stmt.execute(); // COLOCA NO BANCO
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<EmpresaParceira> consulta() {

		PreparedStatement stmt;
		
		ArrayList<EmpresaParceira> empresas = new ArrayList<EmpresaParceira>();
		
		try {
			stmt = conexao.getConn().prepareStatement("select * from empresaparceira");
		
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				// criando o objeto Contato
				EmpresaParceira emp = new EmpresaParceira();
				emp.setNomeUsuario(rs.getString("nomeUsuario"));
				emp.setCnpj(rs.getString("cnpj"));
				emp.setRazaoSocial(rs.getString("razaoSocial"));
				emp.setNomeFantasia(rs.getString("nomeFantasia"));
				emp.setEmail(rs.getString("email"));
				emp.setSenha(rs.getString("senha"));
				// adicionando o objeto lista
				empresas.add(emp);
			}
			rs.close();
			stmt.close();
			//conexao.getConn().close();
		} catch (SQLException e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		return empresas;
		
	}

}
