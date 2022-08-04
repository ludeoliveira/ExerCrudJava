package exercrud;

import exercrud.dao.DaoCachorro;
import exercrud.entidades.Cachorro;
import exercrud.utilidades.Conexao;

public class ExerCrud {

	public static void main(String[] args) {		
//		testarConexao();
//		testarSalvar();
//		testarAlterar();
//		testarConsultar1();
		testarConsultar();
//		testarExcluir();
	}

//	métodos testes de requisições:

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
		Cachorro cachorro = dc.consultar(3);
		cachorro.setRaca("Beagle");
		cachorro.setGrupo("Grupo dos Beagles");
		cachorro.setAltura("30 a 31 cm");
		cachorro.setPersonalidade("Dócil, Inteligente, companheiro");
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
	
	static void testarExcluir() {
		DaoCachorro dc = new DaoCachorro();
		dc.excluir(2);
	}

}
