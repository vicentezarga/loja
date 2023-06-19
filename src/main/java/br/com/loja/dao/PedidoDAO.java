package br.com.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.loja.negocio.model.Pedido;
import br.com.loja.negocio.model.PedidoPK;
import br.com.loja.negocio.model.dto.PeditoDTO;

public class PedidoDAO implements IPedidoDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void cadastrar(Pedido pedido) {

		tx = em.getTransaction();
		if (!tx.isActive()) {
			tx.begin();
		}
		em.persist(pedido);

	}

	public BigDecimal getValorTotalPedidos() {

		String jpql = "SELECT SUM(vlTotal) FROM Pedido";
		
		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
		
	}
	
	public List<PeditoDTO> getRelatorioVendas(){
		
		String jpql = "SELECT new br.com.loja.negocio.model.dto.PeditoDTO ("
				+ "produto.nome, "
				+ "SUM(item.quantidade), "
				+ "MAX(pedido.dataPedido)) "
				+ "FROM "
				+ "Pedido pedido "
				+ "Join pedido.itens item "
				+ "Join item.produto produto "
				+ "GROUP BY produto.nome "
				+ "ORDER BY item.quantidade DESC";
		
		return em.createQuery(jpql, PeditoDTO.class).getResultList();
		
	}
	//Carregamento Planejado
	public Pedido burcarClienteId(PedidoPK id){
		
		return em.createQuery("SELECT p FROM Pedido p Join fetch p.cliente WHERE p.id = :id", Pedido.class)
			   .setParameter("id", id).getSingleResult();
	}

}
