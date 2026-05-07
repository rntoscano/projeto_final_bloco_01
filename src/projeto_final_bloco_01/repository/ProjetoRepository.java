package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Produto;

public interface ProjetoRepository {


	// CRUD do Produto
	public void listarTodos();
	public void cadastrar(Produto produto);
	public void procurarPorCodigo(int codigo);
	public void atualizar(Produto produto);
	public void deletar(int codigo);

	// Estoque
	public void adicionar(int codigo, int quantidade);
	public void remover(int codigo, int quantidade);
}