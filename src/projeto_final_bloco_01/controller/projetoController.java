package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.List;

import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.repository.ProjetoRepository;

public class projetoController implements ProjetoRepository {

	private List<Produto> listaProdutos = new ArrayList<Produto>();
	int codigo = 0;

	@Override
	public void listarTodos() {

		for (Produto produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void cadastrar(Produto produto) {

		listaProdutos.add(produto);

		System.out.printf("O produto %s foi cadastrado com sucesso!%n",
				produto.getNomeProduto());
	}

	@Override
	public void procurarPorCodigo(int codigo) {

		Produto produto = buscarNaCollection(codigo);

		if (produto != null)
			produto.visualizar();
		else
			System.out.println("O Produto não foi encontrado!");
	}

	@Override
	public void atualizar(Produto produto) {

		Produto buscaProduto = buscarNaCollection(produto.getCodigo());

		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);

			System.out.printf("O produto %s foi atualizado com sucesso!%n",
					produto.getNomeProduto());

		} else
			System.out.println("O Produto não foi encontrado!");
	}

	@Override
	public void deletar(int codigo) {

		Produto produto = buscarNaCollection(codigo);

		if (produto != null) {
			listaProdutos.remove(produto);
			System.out.println("O Produto foi deletado com sucesso!");

		} else
			System.out.println("O Produto não foi encontrado!");
	}

	@Override
	public void adicionar(int codigo, int quantidade) {

		Produto produto = buscarNaCollection(codigo);

		if (produto != null) {

			produto.adicionar(quantidade);

			System.out.println("Quantidade adicionada com sucesso!");

		} else
			System.out.println("O Produto não foi encontrado!");
	}

	@Override
	public void remover(int codigo, int quantidade) {

		Produto produto = buscarNaCollection(codigo);

		if (produto != null) {

			produto.remover(quantidade);

			System.out.println("Quantidade removida com sucesso!");

		} else
			System.out.println("O Produto não foi encontrado!");
	}

	public Produto buscarNaCollection(int codigo) {

		for (Produto produto : listaProdutos) {

			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}

		return null;
	}

	public int gerarCodigo() {
		return ++codigo;
	}
}
