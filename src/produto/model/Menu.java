package produto.model;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import loja.util.Cores;
import produto.controller.ProdutoController;

public class Menu {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		ProdutoController produtoController = new ProdutoController();
		int opcao, codigoDoProduto, quantidade, metodoDePagamento;
		String nomeDoProduto, descricaoDoProduto, enderecoDeEntrega, status;
		float preco;

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

			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println("\nLoja de calçados SLOW, desperta o seu estilo!");
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar novo pedido de compra\n");
				System.out.println("Digite o código do produto: \n");
				codigoDoProduto = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o nome do produto: \n");
				nomeDoProduto = scanner.nextLine();
				System.out.println("Digite a descrição do produto: \n");
				descricaoDoProduto = scanner.nextLine();
				System.out.println("Digite a quantidade do produto: \n");
				quantidade = scanner.nextInt();
				System.out.println("Digite o preço do produto: \n");
				preco = scanner.nextFloat();
				System.out.println("Digite o método de pagamento (1- Crédito, 2- Débito): \n");
				metodoDePagamento = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o endereço de entrega: \n");
				enderecoDeEntrega = scanner.nextLine();
				System.out.println("Digite o status do produto: \n");
				status = scanner.nextLine();

				Produto novoProduto = new Tenis(codigoDoProduto, nomeDoProduto, descricaoDoProduto, quantidade, preco,
						metodoDePagamento, enderecoDeEntrega, status);
				produtoController.cadastrar(novoProduto);
				keyPress();
				break;

			case 2:
				System.out.println("Listar produtos disponíveis\n");
				produtoController.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println("Buscar produto por número\n");
				System.out.println("Digite o código do produto: \n");
				codigoDoProduto = scanner.nextInt();
				produtoController.procurarPorNumero(codigoDoProduto);
				keyPress();
				break;

			case 4:
			    System.out.println("Atualizar status de um pedido\n\n");
			    try {
			        System.out.println("Digite o código do produto: ");
			        codigoDoProduto = scanner.nextInt();
			        scanner.nextLine();

			        System.out.println("Digite o novo status do produto: ");
			        status = scanner.nextLine();
			        
			        Produto produtoAtualizado = produtoController.buscarNaCollection(codigoDoProduto);

			        if (produtoAtualizado != null) {
			            produtoAtualizado.setStatus(status);
			            produtoController.atualizar(produtoAtualizado);
			        } else {
			            System.out.println("Produto não encontrado!");
			        }
			    } catch (InputMismatchException e) {
			        System.out.println("Código do produto inválido. Digite um número inteiro.");
			        scanner.nextLine();
			    }
			    keyPress();
			    break;


			case 5:
				System.out.println(Cores.TEXT_RED_BOLD
						+ "Tem certeza que deseja cancelar ou excluir pedidos?\n \nSe sim, selecione o código do produto"
						+ Cores.TEXT_RESET);
				System.out.println("Digite o código do produto: ");
				codigoDoProduto = scanner.nextInt();
				produtoController.deletar(codigoDoProduto);
				keyPress();
				break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção inválida!\n" + Cores.TEXT_RESET);
				keyPress();
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

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
}
