package br.com.loja.negocio.teste;

import java.util.List;

import br.com.loja.negocio.controler.ControlerProduto;
import br.com.loja.negocio.controler.IControlerProduto;
import br.com.loja.negocio.model.Categoria;
import br.com.loja.negocio.model.Produto;
import br.com.loja.negocio.model.Status;

public class CadastroProduto {

	public static void main(String[] args) {
		
		Categoria briquedo = new Categoria("BRIQUEDO", Status.ATIVO, null);

		IControlerProduto serviceControlProduto = new ControlerProduto();
		Produto produto = serviceControlProduto.consultarID(52);
		produto.setDescricao("Carinho de controle Remoto 1500");

		serviceControlProduto.atualizarProduto(produto);

		List<Produto> colecao = serviceControlProduto.buscarProdutoNomeCategoria("BRIQUEDO");

		colecao.forEach(prod -> System.out.println(prod.getDescricao()));

		
	}
}
