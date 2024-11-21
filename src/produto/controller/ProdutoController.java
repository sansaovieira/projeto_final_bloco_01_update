package produto.controller;

import java.util.ArrayList;
import java.util.List;

import loja.util.Cores;
import produto.model.Produto;
import produto.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private List<Produto> listaProdutos = new ArrayList<>();

	@Override
	public void procurarPorNumero(int codigoDoProduto) {
		Produto produto = buscarNaCollection(codigoDoProduto);

		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.println(Cores.TEXT_RED_BOLD + "\nO produto: " + codigoDoProduto + " não foi encontrado!"
					+ Cores.TEXT_RESET);
		}
	}

	@Override
	public void listarTodas() {
		if (listaProdutos.isEmpty()) {
			System.out.println(Cores.TEXT_YELLOW + "\nNão há produtos cadastrados!" + Cores.TEXT_RESET);
		} else {
			for (Produto produto : listaProdutos) {
				produto.visualizar();
			}
		}
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println(Cores.TEXT_GREEN_BOLD + "\nO produto: " + produto.getCodigoDoProduto()
				+ " foi criado com sucesso!" + Cores.TEXT_RESET);
	}

	@Override
	public void atualizar(Produto produtoAtualizado) {
		var produto = buscarNaCollection(produtoAtualizado.getCodigoDoProduto());
		if (produto != null) {
			produto.setStatus(produtoAtualizado.getStatus());
			System.out.println(Cores.TEXT_GREEN_BOLD + "\nO status do produto: " + produto.getCodigoDoProduto()
					+ " foi atualizado com sucesso! Status atualizado para: " + produtoAtualizado.getStatus()
					+ Cores.TEXT_RESET);
		} else {
			System.out.println(Cores.TEXT_RED_BOLD + "\nO produto: " + produtoAtualizado.getCodigoDoProduto()
					+ " não foi encontrado!" + Cores.TEXT_RESET);
		}
	}

	@Override
	public void deletar(int codigoDoProduto) {
		Produto produto = buscarNaCollection(codigoDoProduto);

		if (produto != null) {
			listaProdutos.remove(produto);
			System.out.println(Cores.TEXT_RED_BOLD + "\nO produto: " + codigoDoProduto + " foi deletado com sucesso!"
					+ Cores.TEXT_RESET);
		} else {
			System.out.println(Cores.TEXT_RED_BOLD + "\nO produto: " + codigoDoProduto + " não foi encontrado!"
					+ Cores.TEXT_RESET);
		}
	}

	@Override
	public void adicionarProduto(int codigoDoProduto, int quantidade) {
		Produto produto = buscarNaCollection(codigoDoProduto);

		if (produto != null) {
			if (produto.adicionarProduto(quantidade)) {
				System.out.println(Cores.TEXT_GREEN_BOLD + "\nA quantidade do produto " + codigoDoProduto
						+ " foi aumentada em " + quantidade + " unidades." + Cores.TEXT_RESET);
			} else {
				System.out.println(Cores.TEXT_RED_BOLD + "\nEstoque insuficiente para o produto " + codigoDoProduto
						+ "!" + Cores.TEXT_RESET);
			}
		} else {
			System.out.println(
					Cores.TEXT_RED_BOLD + "\nO produto " + codigoDoProduto + " não foi encontrado!" + Cores.TEXT_RESET);
		}
	}

	@Override
	public void reabastecerProduto(int codigoDoProduto, int quantidade) {
		Produto produto = buscarNaCollection(codigoDoProduto);

		if (produto != null) {
			produto.reabastecerProduto(quantidade);
			System.out.println(Cores.TEXT_GREEN_BOLD + "\nA quantidade do produto " + codigoDoProduto
					+ " foi aumentada em " + quantidade + " unidades." + Cores.TEXT_RESET);
		} else {
			System.out.println(
					Cores.TEXT_RED_BOLD + "\nO produto " + codigoDoProduto + " não foi encontrado!" + Cores.TEXT_RESET);
		}
	}

	public Produto buscarNaCollection(int codigoDoProduto) {
		for (Produto produto : listaProdutos) {
			if (produto.getCodigoDoProduto() == codigoDoProduto) {
				return produto;
			}
		}
		return null;
	}
}
