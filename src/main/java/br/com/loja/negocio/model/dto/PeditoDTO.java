package br.com.loja.negocio.model.dto;

import java.time.LocalDate;

public class PeditoDTO {
	
	private String nomeProduto;
	
	private long quantidadeVendida;
	
	private LocalDate dataUltimaVenda;

	public PeditoDTO(String nomeProduto, long quantidadeVendida, LocalDate dataUltimaVenda) {
		super();
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
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
}
