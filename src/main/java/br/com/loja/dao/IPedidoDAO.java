package br.com.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.loja.negocio.model.Pedido;
import br.com.loja.negocio.model.dto.PeditoDTO;

public interface IPedidoDAO {

	public void cadastrar(Pedido p);

	public BigDecimal getValorTotalPedidos();
	
	public List<PeditoDTO> getRelatorioVendas();
}
