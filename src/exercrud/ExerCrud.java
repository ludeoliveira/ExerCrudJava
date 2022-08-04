package exercrud;

import exercrud.dao.DaoCachorro;
import exercrud.entidades.Cachorro;
import exercrud.utilidades.Conexao;

public class ExerCrud {

	public static void main(String[] args) {
		DaoCachorro dc = new DaoCachorro();
		
//		testarConexao();
//		testarSalvar();
//		testarAlterar();
//		testarConsultar1();
		testarConsultar();
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
	
	static void testarAlterar() {
		DaoCachorro dc = new DaoCachorro();
		Cachorro cachorro = dc.consultar(1);
		cachorro.setRaca("Border Collie");
		cachorro.setGrupo("Grupo dos Pastores");
		cachorro.setAltura("48 a 56 cm");
		cachorro.setPersonalidade("Gentil, Inteligente, ágil");

		if (dc.alterar(cachorro)) {
			System.out.println("Cachorro alterado com sucesso");
		}
		else {
			System.out.println("Erro ao alterar dados");
		}
	}
	
	static void testarConsultar1() { 
		DaoCachorro dc = new DaoCachorro();
		Cachorro cachorro = dc.consultar(1);
		System.out.println(cachorro);
	}
	
	static void testarConsultar() { 
		DaoCachorro dc = new DaoCachorro();
		System.out.println(dc.consultar());
	}

}
