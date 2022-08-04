package exercrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import exercrud.entidades.Cachorro;
import exercrud.interfaces.ICrud;
import exercrud.utilidades.Conexao;

public class DaoCachorro implements ICrud<Cachorro> {

	@Override
	public boolean salvar(Cachorro obj) {
		String sql = "insert into cachorro(raca, grupo, altura, personalidade)values(?, ?, ?, ?)";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getRaca());
			stm.setString(2, obj.getGrupo());
			stm.setString(3, obj.getAltura());
			stm.setString(4, obj.getPersonalidade());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar();
		}
		return true;
	}

	@Override
	public boolean alterar(Cachorro obj) {
		String sql = "update cachorro set\r\n"
				+ "raca = ?,\r\n"
				+ "grupo = ?,\r\n"
				+ "altura = ?,\r\n"
				+ "personalidade =?\r\n"
				+ "where id = ?";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getRaca());
			stm.setString(2, obj.getGrupo());
			stm.setString(3, obj.getAltura());
			stm.setString(4, obj.getPersonalidade());
			stm.setInt(5, obj.getId());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar();
		}
		return true;
	}

	@Override
	public void excluir(int id) {
		String sql = "delete from cachorro where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}	
	}

	@Override
	public Cachorro consultar(int id) {
		Cachorro cachorro = new Cachorro();
		String sql = "select * from cachorro where id = " + id;
		Connection con = Conexao.conectar();
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				cachorro.setId(rs.getInt("id"));
				cachorro.setRaca(rs.getString("raca"));
				cachorro.setGrupo(rs.getString("grupo"));
				cachorro.setAltura(rs.getString("altura"));
				cachorro.setPersonalidade(rs.getString("personalidade"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}		
		return cachorro;		
	}

	@Override
	public List<Cachorro> consultar() {
		List<Cachorro> cachorros = new ArrayList<>();
		String sql = "select * from cachorro";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Cachorro cachorro = new Cachorro();
				cachorro.setId(rs.getInt("id"));
				cachorro.setRaca(rs.getString("raca"));
				cachorro.setGrupo(rs.getString("grupo"));
				cachorro.setAltura(rs.getString("altura"));
				cachorro.setPersonalidade(rs.getString("personalidade"));
				cachorros.add(cachorro);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}	
		return cachorros;
	}
		
}

