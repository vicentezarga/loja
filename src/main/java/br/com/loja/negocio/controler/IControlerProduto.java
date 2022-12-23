package br.com.loja.negocio.controler;

import java.util.List;

import br.com.loja.negocio.model.Produto;

public interface IControlerProduto {

	public void salvar(Produto pProduto);

	public void remover(long idProduto);

	public void atualizarProduto(Produto pProduto);

	public Produto consultarID(long id);

	public List<Produto> buscarTodos();
	
	public List<Produto> buscarProdutoNome(String pNome);
	
	public List<Produto> buscarProdutoNomeCategoria(String pNomeCategoria);
	

}
