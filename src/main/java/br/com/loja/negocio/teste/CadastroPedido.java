package br.com.loja.negocio.teste;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.loja.dao.CategoriaDAO;
import br.com.loja.dao.IProdutoDAO;
import br.com.loja.dao.JPAUtil;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.negocio.model.Categoria;
import br.com.loja.negocio.model.Cliente;
import br.com.loja.negocio.model.ItemPedido;
import br.com.loja.negocio.model.Pedido;
import br.com.loja.negocio.model.Produto;
import br.com.loja.negocio.model.Status;

public class CadastroPedido {

	public static void main(String[] args) {

		try (JPAUtil jp = new JPAUtil()) {
			
			EntityManager em = jp.getConectar();
			
			Categoria categoria = new Categoria("Console", Status.ATIVO, null);

			Produto produto = new Produto("PS4", "Play Station slim", new BigDecimal("6000"), categoria);

			CategoriaDAO catDAO = new CategoriaDAO(em);
			catDAO.cadastrar(categoria);

			produto.setCategoria(categoria);
			
			IProdutoDAO controleProduto = new ProdutoDAO(em);
			controleProduto.salvar(produto);
			
			Cliente cliente = new Cliente("Vicente", "01358347409");
			Pedido pedido = new Pedido(LocalDate.now(), cliente);
			pedido.adicionarItem(new ItemPedido(10, pedido, produto));
			
			EntityTransaction tx = em.getTransaction();
			
			if(!tx.isActive()) {
				tx.begin();
			}
			
			em.persist(cliente);
			em.persist(pedido);
			tx.commit();
		
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
