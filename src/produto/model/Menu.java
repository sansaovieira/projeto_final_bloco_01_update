package produto.model;

import java.util.Scanner;

import loja.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Produto p1 = new Tenis(1, "Tênis Nike", "Tênis de corrida", 5, 250.0f, 1, "Rua Manoel Patricío de Menezes 123", "disponível");
		Produto p2 = new Tenis(2, "Tênis Air Jordan", "Tênis de esporte", 2, 950.0f, 1, "Av. Tiradentes 123", "Processando");
		
		p1.adicionarProduto(2);
		p1.reabastecerProduto(1);
		p1.visualizar();
		
		p2.adicionarProduto(2);
		p2.reabastecerProduto(1);
		p2.visualizar();

		Scanner scanner = new Scanner(System.in);

		int opcao;

		while (true) {
			System.out.println("************************************************************************");
			System.out.println("************************************************************************");
			System.out.println("                                                                        ");
			System.out.println(Cores.TEXT_WHITE_BOLD
					+ "                   🛍 LOJA DE CALÇADOS SLOW - LINHA NIKE                " + Cores.TEXT_RESET);
			System.out.println("                                                                        ");
			System.out.println("                         ➕ 1 - Criar novo pedido de compra                       ");
			System.out.println("                         📋 2 - Listar produtos disponíveis                ");
			System.out.println("                         🔎 3 - Buscar produto por número               ");
			System.out.println("                         ✏ 4 - Atualizar status de um pedido              ");
			System.out.println(Cores.TEXT_RED_BOLD
					+ "                         🗑 5 - Cancelar ou excluir pedidos                          "
					+ Cores.TEXT_RESET);
			System.out.println("                         ⬅ 6 - Sair                                    ");
			System.out.println("                                                     ");
			System.out.println("*************************************************************************");
			System.out.println("Entre com a opção desejada:                          ");

			opcao = scanner.nextInt();

			if (opcao == 6) {
				System.out.println("\nLoja de calçados SLOW, desperta o seu estilo!");
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar novo pedido de compra\n\n");
				break;

			case 2:
				System.out.println("Listar produtos disponíveisn\n\n");
				break;

			case 3:
				System.out.println("Buscar produto por número\n\n");
				break;

			case 4:
				System.out.println("Atualizar status de um pedido\n\n");
				break;

			case 5:
				System.out.println("Cancelar ou excluir pedidos\n\n");
				break;

			default:
				System.out.println("\n Opção inválida!\n\n");
				break;
			}

		}

	}

	public static void sobre() {
		System.out.println("\n*************************************************************************");
		System.out.println("Projeto Desenvolvido por: Sansão Dembué Vieira");
		System.out.println("Linkedin - https://www.linkedin.com/in/sansaovieira/");
		System.out.println("https://github.com/sansaovieira");
		System.out.println("***************************************************************************");
	}

}
