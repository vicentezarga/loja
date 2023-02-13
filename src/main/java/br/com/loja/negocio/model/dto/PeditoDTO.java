package br.com.loja.negocio.model.dto;

import java.time.LocalDate;

public class PeditoDTO {
	
	private String nomeProduto;
	
	private long quantidadeVendida;
	
	private LocalDate dataUltimaVenda;
	
	private ClienteDTO clienteDTO;
	
	public PeditoDTO(String nomeProduto, long quantidadeVendida, LocalDate dataUltimaVenda) {
		super();
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}
	
	public PeditoDTO(String nomeProduto, long quantidadeVendida, LocalDate dataUltimaVenda, ClienteDTO clienteDTO) {
		super();
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
		this.clienteDTO = clienteDTO;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public LocalDate getDataUltimaVenda() {
		return dataUltimaVenda;
	}

	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public void setQuantidadeVendida(long quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	public void setDataUltimaVenda(LocalDate dataUltimaVenda) {
		this.dataUltimaVenda = dataUltimaVenda;
	}
	
	
}
