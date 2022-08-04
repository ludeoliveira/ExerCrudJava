package exercrud;

import exercrud.dao.DaoCachorro;
import exercrud.entidades.Cachorro;
import exercrud.utilidades.Conexao;

public class ExerCrud {

	public static void main(String[] args) {
		DaoCachorro dc = new DaoCachorro();
		
//		testarConexao();
		testarSalvar();
	}

//	testes de requisições:

	static void testarConexao() {
		if (Conexao.conectar() != null) {
			System.out.println("conectado");
		} else {
			System.out.println("Erro ao conectar");
		}
	}

	static void testarSalvar() {
		DaoCachorro dc = new DaoCachorro();
		Cachorro c1 = new Cachorro("Dalmata", "Não Esportistas", "56 a 61 cm", "Amigável, ativo, brincalhão, extrovertido");

		if (dc.salvar(c1)) {
			System.out.println("Cachorro cadastrado com sucesso");
		}
		else {
			System.out.println("Erro ao cadastrar");
		}

	}

}
