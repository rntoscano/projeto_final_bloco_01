package projeto_final_bloco_01.model;

public class Produto {
	
	private String nomeProduto;
	private int quantidade;
	private float preco;
	private int codigo;
	private int tipo;
	
	public Produto(String nomeProduto, int quantidade, float preço, int codigo, int tipo) {
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.preco = preço;
		this.codigo = codigo;
		this.tipo = tipo;
	}
	

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void adicionar(int qtd) {
		this.quantidade = this.quantidade + qtd;
	}
	public void remover(int qtd) {
		this.quantidade = this.quantidade - qtd;
	}
	
	public void visualizar() {

		String tipoProduto = "";

		switch (this.tipo) {
		case 1:
			tipoProduto = "Pereciveis";
			break;
		case 2:
			tipoProduto = "Refrigerados";
			break;
		}

		System.out.println("\n\n***********************************************************");
		System.out.println("Nome Produto:");
		System.out.println("***********************************************************");
		System.out.println("Tipo de Produto: " + tipo);
		System.out.println("Nome do Produto: " + this.nomeProduto);
		System.out.println("Codigo do Produto: " + this.codigo);
		System.out.println("Preço do Produto: " + this.preco);
	}
}
