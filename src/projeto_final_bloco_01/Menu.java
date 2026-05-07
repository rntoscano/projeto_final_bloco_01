package projeto_final_bloco_01;

import java.time.LocalDate;
import java.util.Scanner;

import projeto_final_bloco_01.controller.projetoController;
import projeto_final_bloco_01.model.Mercearia;
import projeto_final_bloco_01.model.Refrigerado;
import projeto_final_bloco_01.util.Cores;
import projeto_final_bloco_01.model.Produto;
import java.time.format.DateTimeFormatter;

public class Menu {

	private static final Scanner leia = new Scanner(System.in);
	private static final projetoController produtoController = new projetoController();

	public static void main(String[] args) {

		criarProdutosTeste();

		int opcao;

		while (true) {
			System.out.println(Cores.BACKGROUND_YELLOW_PASTEL + Cores.TEXT_BLACK_BOLD);

			System.out.println("*****************************************************");
			System.out.println("                 Padaria Doce Sonho                  ");
			System.out.println("*****************************************************");
			System.out.println("            1 - Adicionar Produto                    ");
			System.out.println("            2 - Atualizar Produto                    ");
			System.out.println("            3 - Listar Produtos                      ");
			System.out.println("            4 - Consultar Produto                    ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println("\nPadaria Doce Sonho - Produzindo Bons Sonhos!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Adicionar Produto\n");
				cadastrarProduto();

				keyPress();
				break;

			case 2:
				System.out.println("Atualizar Produto\n");
				atualizarProduto();
				keyPress();
				break;

			case 3:
				System.out.println("Listar Produtos\n");
				listarProdutos();
				keyPress();
				break;

			case 4:
				System.out.println("Consultar Produto\n");
				procurarProdutoPorCodigo();
				keyPress();
				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

	private static void cadastrarProduto() {

		System.out.print("Digite o nome do Produto: ");
		leia.skip("\\R?");
		String nomeProduto = leia.nextLine();

		System.out.print("Digite a quantidade do Produto: ");
		int quantidade = leia.nextInt();

		System.out.print("Digite o preço do Produto: ");
		float preco = leia.nextFloat();

		System.out.print("Digite o tipo do Produto (1 - Mercearia | 2 - Refrigerado): ");
		int tipo = leia.nextInt();

		switch (tipo) {
		case 1:

			leia.nextLine();

			System.out.print("Digite a validade (dd/MM/yyyy): ");
			String dataTexto = leia.nextLine();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			LocalDate validade = LocalDate.parse(dataTexto, formatter);

			produtoController.cadastrar(
					new Mercearia(nomeProduto, quantidade, preco, produtoController.gerarCodigo(), tipo, validade));
			keyPress();
			break;

		case 2:
			System.out.print("Digite a temperatura do Produto: ");
			float temperatura = leia.nextFloat();

			produtoController.cadastrar(new Refrigerado(nomeProduto, quantidade, preco, produtoController.gerarCodigo(),
					tipo, temperatura));
			keyPress();
			break;

		default:
			System.out.println("Tipo de produto inválido!");
			keyPress();
			break;
		}
	}

	public static void listarProdutos() {
		produtoController.listarTodos();
	}

	private static void procurarProdutoPorCodigo() {
		System.out.print("Digite o código do Produto: ");
		int codigo = leia.nextInt();

		produtoController.procurarPorCodigo(codigo);
	}

	private static void criarProdutosTeste() {

		produtoController.cadastrar(
				new Mercearia("Pão Francês", 50, 0.80f, produtoController.gerarCodigo(), 1, LocalDate.of(2026, 5, 20)));

		produtoController.cadastrar(new Mercearia("Bolo de Chocolate", 10, 35.00f, produtoController.gerarCodigo(), 1,
				LocalDate.of(2026, 5, 15)));

		produtoController.cadastrar(new Refrigerado("Leite", 20, 7.50f, produtoController.gerarCodigo(), 2, 5.0f));

		produtoController.cadastrar(new Refrigerado("Iogurte", 15, 4.99f, produtoController.gerarCodigo(), 2, 3.0f));
	}

	private static void atualizarProduto() {

		System.out.print("Digite o código do Produto: ");
		int codigo = leia.nextInt();
		leia.nextLine();

		Produto produto = produtoController.buscarNaCollection(codigo);

		if (produto != null) {

			System.out.print("Nome atual: " + produto.getNomeProduto() + "\nNovo nome: ");
			String nomeProduto = leia.nextLine();
			nomeProduto = nomeProduto.isEmpty() ? produto.getNomeProduto() : nomeProduto;

			System.out.print("Quantidade atual: " + produto.getQuantidade() + "\nNova quantidade: ");
			String entrada = leia.nextLine();
			int quantidade = entrada.isEmpty() ? produto.getQuantidade() : Integer.parseInt(entrada);

			System.out.print("Preço atual: " + produto.getPreco() + "\nNovo preço: ");
			entrada = leia.nextLine();
			float preco = entrada.isEmpty() ? produto.getPreco() : Float.parseFloat(entrada.replace(',', '.'));

			produto.setNomeProduto(nomeProduto);
			produto.setQuantidade(quantidade);
			produto.setPreco(preco);

			produtoController.atualizar(produto);

		} else {
			System.out.println("\nO Produto código " + codigo + " não foi encontrado!");
		}
	}

	public static void keyPress() {

		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		leia.nextLine();
	}

	public static void sobre() {
		System.out.println(Cores.BACKGROUND_YELLOW_PASTEL + Cores.TEXT_BLACK_BOLD);
		System.out.println("\n*****************************************************");
		System.out.println("Projeto Desenvolvido por: Riane Toscano              ");
		System.out.println("anny.toscano@hotmail.com                             ");
		System.out.println("https://github.com/rntoscano                         ");
		System.out.println("*****************************************************" + Cores.TEXT_RESET);
	}
}