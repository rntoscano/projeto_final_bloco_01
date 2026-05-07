package projeto_final_bloco_01.model;

public class Refrigerado extends Produto {
	
	private float temperatura;

	public Refrigerado(String nomeProduto, int quantidade, float preço, int codigo, int tipo, float f) {
		super(nomeProduto, quantidade, preço, codigo, tipo);
		
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public void visualizar() {

		super.visualizar();
		System.out.println("Temperatura necessaria: " + this.temperatura + "°C");
	}
}