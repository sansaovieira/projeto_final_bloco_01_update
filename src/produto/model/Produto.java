package produto.model;

import loja.util.Cores;

public class Produto {
	private int codigoDoProduto;
	private String nomeDoProduto;
	private String descricaoDoProduto;
	private int quantidadeDoProduto;
	private float preco;
	private int metodoDePagamento;
	private String enderecoDeEntrega;
	private String status;

	public Produto(int codigoDoProduto, String nomeDoProduto, String descricaoDoProduto, int quantidadeDoProduto,
			float preco, int metodoDePagamento, String enderecoDeEntrega, String status) {
		this.codigoDoProduto = codigoDoProduto;
		this.nomeDoProduto = nomeDoProduto;
		this.descricaoDoProduto = descricaoDoProduto;
		this.quantidadeDoProduto = quantidadeDoProduto;
		this.preco = preco;
		this.metodoDePagamento = metodoDePagamento;
		this.enderecoDeEntrega = enderecoDeEntrega;
		this.status = status;
	}

	public int getCodigoDoProduto() {
		return codigoDoProduto;
	}

	public void setCodigoDoProduto(int codigoDoProduto) {
		this.codigoDoProduto = codigoDoProduto;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public String getDescricaoDoProduto() {
		return descricaoDoProduto;
	}

	public void setDescricaoDoProduto(String descricaoDoProduto) {
		this.descricaoDoProduto = descricaoDoProduto;
	}

	public int getQuantidadeDoProduto() {
		return quantidadeDoProduto;
	}

	public void setQuantidadeDoProduto(int quantidadeDoProduto) {
		this.quantidadeDoProduto = quantidadeDoProduto;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getMetodoDePagamento() {
		return metodoDePagamento;
	}

	public void setMetodoDePagamento(int metodoDePagamento) {
		this.metodoDePagamento = metodoDePagamento;
	}

	public String getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(String enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean adicionarProduto(int quantidade) {
		if (this.getQuantidadeDoProduto() < quantidade) {
			System.out.println("\n Estoque Insuficiente!");
			return false;
		}
		this.setQuantidadeDoProduto(this.getQuantidadeDoProduto() - quantidade);
		System.out.println(Cores.TEXT_GREEN_BOLD + "\n Produto adicionado ao pedido com sucesso!" + Cores.TEXT_RESET);
		return true;
	}

	public void reabastecerProduto(int quantidade) {
		this.setQuantidadeDoProduto(this.getQuantidadeDoProduto() + quantidade);
		System.out.println(Cores.TEXT_GREEN_BOLD + "\n Estoque atualizado com sucesso!" + Cores.TEXT_RESET);
	}

	public void visualizar() {
		String metodoPagamento = "";
		switch (this.metodoDePagamento) {
		case 1:
			metodoPagamento = "Credito";
			break;
		case 2:
			metodoPagamento = "Debito";
			break;
		}
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do produto:");
		System.out.println("***********************************************************");
		System.out.println("Código do produto: " + this.codigoDoProduto);
		System.out.println("Nome do produto: " + this.nomeDoProduto);
		System.out.println("Método de pagamento: " + metodoPagamento);
		System.out.println("Descrição do produto: " + this.descricaoDoProduto);
		System.out.println("Quantidade: " + this.quantidadeDoProduto);
		System.out.println("Preço: R$ "+ this.preco);
		System.out.println("Endereço: " + this.enderecoDeEntrega);
		System.out.println("Status: " + this.status);
	}

}
