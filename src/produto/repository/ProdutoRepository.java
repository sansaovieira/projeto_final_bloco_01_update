package produto.repository;

import produto.model.Produto;

public interface ProdutoRepository {
	// CRUD de produtos
	public void procurarPorNumero(int codigoDoProduto);

	public void listarTodas();

	public void cadastrar(Produto nomeDoProduto);

	public void atualizar(Produto status);

	public void deletar(int codigoDoProduto);

	// Métodos dos produtos

	void adicionarProduto(int codigoDoProduto, int quantidade);

	void reabastecerProduto(int codigoDoProduto, int quantidade);

}
