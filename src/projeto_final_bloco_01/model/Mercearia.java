package projeto_final_bloco_01.model;

import java.time.LocalDate;

public class Mercearia extends Produto {
	
	private LocalDate dataValidade; 
	
	public Mercearia(String nomeProduto, int quantidade, float preço, int codigo, int tipo, LocalDate dataValidade) {
		super(nomeProduto, quantidade, preço, codigo, tipo);
		this.dataValidade = dataValidade;
		
		
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public boolean atualizarValidade(LocalDate novaData) {

		if(novaData.isBefore(LocalDate.now())) {
			System.out.println("\nFora da data de validade!");
			return false;
		}

		this.setDataValidade(novaData);
		return true;
		
	}
	
  
	public void visualizar() {
		super.visualizar();
		System.out.println("Dentro da data de validade: " + this.dataValidade);
	}
}
