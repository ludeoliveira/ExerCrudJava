package exercrud.entidades;

public class Cachorro {
	private int id;
	private String raca;
	private String grupo;
	private String altura;
	private String personalidade;
	
	public Cachorro(String raca, String grupo, String altura, String personalidade) {
		this.raca = raca;
		this.grupo = grupo;
		this.altura = altura;
		this.personalidade = personalidade;
	}
	
	public Cachorro() {	
	}
	
	@Override
	public String toString() {
		return "Cachorro [id=" + id + ", raca=" + raca + ", grupo=" + grupo + ", altura=" + altura + ", personalidade="
				+ personalidade + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPersonalidade() {
		return personalidade;
	}

	public void setPersonalidade(String personalidade) {
		this.personalidade = personalidade;
	}	
}
