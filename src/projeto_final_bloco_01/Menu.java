package projeto_final_bloco_01;

import java.util.Scanner;
import projeto_final_bloco_01.util.Cores;
import projeto_final_bloco_01.model.Produto;


public class Menu {
	public static void main(String[] args) {
		
		Produto p1 = new Produto("Pão Francês", 50, 0.80f, 1, 1);

		p1.visualizar();

		p1.adicionar(20);
		p1.visualizar();

		p1.remover(10);
		p1.visualizar();

		p1.setPreco(1.00f);
		p1.setNomeProduto("Pão Integral");
		p1.visualizar();

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {
			System.out.println(
					Cores.BACKGROUND_YELLOW_PASTEL +
					Cores.TEXT_BLACK_BOLD
			);

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                 Padaria Doce Sonho                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Adicionar Produto                    ");
			System.out.println("            2 - Atualizar Produto                    ");
			System.out.println("            3 - Listar Produtos                      ");
			System.out.println("            4 - Excluir Produto                      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
		

			opcao = leia.nextInt();

			if (opcao == 0) {

				System.out.println(
					Cores.BACKGROUND_YELLOW_PASTEL +
					Cores.TEXT_BLACK_BOLD
			);
				System.out.println("\n    Padaria Doce Sonho - Produzindo Bons Sonhos!     ");
				sobre();
                 leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println("Adicionar Produto\n\n");

					break;
				case 2:
					System.out.println("Atualizar Produto\n\n");

					break;
				case 3:
					System.out.println("Listar Produtos\n\n");

					break;
				case 4:
					System.out.println("Excluir Produto\n\n");


					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					break;
			}
		}
	}
    
	public static void sobre() {
		System.out.println("\n*****************************************************");
		System.out.println("Projeto Desenvolvido por: Riane Toscano              ");
		System.out.println("anny.toscano@hotmail.com                             ");
		System.out.println("https://github.com/rntoscano                         ");
		System.out.println("*****************************************************");
	}
}
