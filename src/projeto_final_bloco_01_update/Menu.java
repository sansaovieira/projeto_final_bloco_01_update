package projeto_final_bloco_01_update;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int opcao;

		while (true) {
			System.out.println("************************************************************************");
			System.out.println("************************************************************************");
			System.out.println("                                                                        ");
			System.out.println("                   🛍 LOJA DE CALÇADOS SLOW - LINHA NIKE                ");
			System.out.println("                                                                        ");
			System.out.println("                         ➕ 1 - Cadastrar produto                       ");
			System.out.println("                         📋 2 - Listar todos os produtos                ");
			System.out.println("                         🔎 3 - Buscar produto por número               ");
			System.out.println("                         ✏ 4 - Atualizar dados do produto              ");
			System.out.println("                         🗑 5 - Apagar produto                          ");
			System.out.println("                         🛒 6 - comprar                                 ");
			System.out.println("                         ⬅ 7 - Sair                                    ");
			System.out.println("                                                     ");
			System.out.println("*************************************************************************");
			System.out.println("Entre com a opção desejada:                          ");

			opcao = scanner.nextInt();

			if (opcao == 7) {
				System.out.println("\nLoja de calçados SLOW, desperta o seu estilo!");
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar produto\n\n");
				break;

			case 2:
				System.out.println("Listar todos os produtosn\n\n");
				break;

			case 3:
				System.out.println("Buscar produto por número\n\n");
				break;

			case 4:
				System.out.println("Atualizar dados do produto\n\n");
				break;

			case 5:
				System.out.println("Apagar produto\n\n");
				break;

			case 6:
				System.out.println("Comprar produto");
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
