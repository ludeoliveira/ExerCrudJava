package exercrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cachorro consultar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cachorro> consultar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
