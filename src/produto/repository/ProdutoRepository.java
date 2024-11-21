package produto.repository;

import produto.model.Produto;

public interface ProdutoRepository {
	// CRUD da Loja
	public void procurarPorNumero(int codigoDoProduto);

	public void listarTodas();

	public void cadastrar(Produto nomeDoProduto);

	public void atualizar(Produto status);

	public void deletar(int codigoDoProduto);

	// Métodos da Loja
	public void adicionarProduto(int numero, float valor);

	public void reabastecerProduto(int numero, float valor);

}
