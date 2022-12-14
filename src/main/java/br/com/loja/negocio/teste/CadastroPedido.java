package br.com.loja.negocio.teste;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.dao.CategoriaDAO;
import br.com.loja.dao.ClienteDAO;
import br.com.loja.dao.IClienteDAO;
import br.com.loja.dao.IPedidoDAO;
import br.com.loja.dao.IProdutoDAO;
import br.com.loja.dao.JPAUtil;
import br.com.loja.dao.PedidoDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.negocio.model.Categoria;
import br.com.loja.negocio.model.Cliente;
import br.com.loja.negocio.model.ItemPedido;
import br.com.loja.negocio.model.Pedido;
import br.com.loja.negocio.model.Produto;
import br.com.loja.negocio.model.Status;
import br.com.loja.negocio.model.dto.PeditoDTO;

public class CadastroPedido {

	public static void main(String[] args) {

		try (JPAUtil jp = new JPAUtil()) {
			
			EntityManager em = jp.getConectar();
			
			Categoria categoria = new Categoria("Console", Status.ATIVO, null);

			Produto produto1 = new Produto("PS4", "Play Station slim", new BigDecimal("6000"), categoria);
			Produto produto2 = new Produto("Xbox One", "Xbox Edit Limited", new BigDecimal("2000"), categoria);
			
			CategoriaDAO catDAO = new CategoriaDAO(em);
			catDAO.cadastrar(categoria);

			produto1.setCategoria(categoria);
			produto2.setCategoria(categoria);
			
			IProdutoDAO controleProduto = new ProdutoDAO(em);
			controleProduto.salvar(produto1);
			controleProduto.salvar(produto2);
			
			Cliente cliente = new Cliente("Vicente", "01358347409");
			Pedido pedido1 = new Pedido(LocalDate.now(), cliente);
			pedido1.adicionarItem(new ItemPedido(10, pedido1, produto1));

			Pedido pedido2 = new Pedido(LocalDate.now(), cliente);
			pedido2.adicionarItem(new ItemPedido(2, pedido2, produto2));

			
			IPedidoDAO pedidoDAO = new PedidoDAO(em);
			pedidoDAO.cadastrar(pedido1);
			pedidoDAO.cadastrar(pedido2);

			IClienteDAO clienteDAO = new ClienteDAO(em);
			clienteDAO.cadastrar(cliente);
			
			BigDecimal vlTotalPedidos = pedidoDAO.getValorTotalPedidos();
			
			System.out.println("Valor Total:" + vlTotalPedidos);
			
			List<PeditoDTO> colecaoPedido = pedidoDAO.getRelatorioVendas();
			
			colecaoPedido.stream().forEach(item -> {
				
				System.out.println("Produto: " + item.getNomeProduto());
				System.out.println("Quantidade: " + item.getQuantidadeVendida());
				System.out.println("Data: " + item.getDataUltimaVenda());
				
			});
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
