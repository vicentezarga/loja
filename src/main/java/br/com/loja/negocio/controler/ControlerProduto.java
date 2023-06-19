package br.com.loja.negocio.controler;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.dao.IProdutoDAO;
import br.com.loja.dao.JPAUtil;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.negocio.model.Produto;

public class ControlerProduto implements IControlerProduto {

	private EntityManager em;
	private IProdutoDAO daoProduto;

	@Override
	public void salvar(Produto pProduto) {

		try (JPAUtil jp = new JPAUtil()) {

			em = jp.getConectar();
			daoProduto = new ProdutoDAO(em);
			daoProduto.salvar(pProduto);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void remover(long idProduto) {

		try (JPAUtil jp = new JPAUtil()) {

			em = jp.getConectar();
			daoProduto = new ProdutoDAO(em);
			daoProduto.remover(idProduto);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizarProduto(Produto pProduto) {

		try (JPAUtil jp = new JPAUtil()) {

			em = jp.getConectar();

			daoProduto = new ProdutoDAO(em);
			daoProduto.atualizarProduto(pProduto);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produto consultarID(long id) {

		Produto produto = null;

		try (JPAUtil jp = new JPAUtil()) {

			em = jp.getConectar();
			daoProduto = new ProdutoDAO(em);
			produto = daoProduto.consultarID(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return produto;
	}

	@Override
	public List<Produto> buscarTodos() {
		
		List<Produto> colecao = null;
		
		try (JPAUtil jp = new JPAUtil()) {

			em = jp.getConectar();
			daoProduto = new ProdutoDAO(em);
			colecao = daoProduto.buscarTodos();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return colecao;
	}

	@Override
	public List<Produto> buscarProdutoNome(String pNome) {
		
		List<Produto> colecao = null;
		
		try (JPAUtil jp = new JPAUtil()) {

			em = jp.getConectar();
			daoProduto = new ProdutoDAO(em);
			colecao = daoProduto.buscarProdutoNome(pNome);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colecao;
	}
	
	@Override
	public List<Produto> buscarProdutosCriteria(String nome, BigDecimal preco, LocalDateTime dataCadastro) {
		
		List<Produto> colecao = null;
		
		try (JPAUtil jp = new JPAUtil()) {

			em = jp.getConectar();
			daoProduto = new ProdutoDAO(em);
			colecao = daoProduto.buscarProdutosCriteria(nome, preco, dataCadastro);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return colecao;
	}
	
	public List<Produto> buscarProdutoNomeCategoria(String pNomeCategoria) {

		List<Produto> colecao = null;
		
		try (JPAUtil jp = new JPAUtil()) {

			em = jp.getConectar();
			daoProduto = new ProdutoDAO(em);
			colecao = daoProduto.buscarProdutoNomeCategoria(pNomeCategoria);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return colecao;
	}
}
