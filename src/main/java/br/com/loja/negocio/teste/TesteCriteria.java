package br.com.loja.negocio.teste;

import java.math.BigDecimal;
import java.util.List;

import br.com.loja.dao.CategoriaDAO;
import br.com.loja.dao.JPAUtil;
import br.com.loja.negocio.controler.ControlerProduto;
import br.com.loja.negocio.controler.IControlerProduto;
import br.com.loja.negocio.model.Categoria;
import br.com.loja.negocio.model.Produto;

public class TesteCriteria {

	public static void main(String[] args) {
		
		JPAUtil jp = new JPAUtil();
		
		popularBancoDeDados(jp);

		IControlerProduto controller = new ControlerProduto();
		List<Produto> produtos = controller.buscarProdutosCriteria("PS5", null, null);
		produtos.forEach(p -> System.out.println(p.getNome()));
	}

	private static void popularBancoDeDados(JPAUtil jp) {
		
		IControlerProduto controller = new ControlerProduto();
		
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");

		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("8000"), videogames);
		Produto macbook = new Produto("Macbook", "Macboo pro retina", new BigDecimal("14000"), informatica);

		CategoriaDAO categoriaDao = new CategoriaDAO(jp.getConectar());
		
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);

		controller.salvar(celular);
		controller.salvar(videogame);
		controller.salvar(macbook);

	}

}
