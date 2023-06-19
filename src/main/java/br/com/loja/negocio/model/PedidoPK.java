package br.com.loja.negocio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PedidoPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6334471364515400541L;

	@Column(length = 50)
	private String idCliente;

	@Column(length = 50)
	private String coditoPedido;

	public PedidoPK() {
		
	}
	
	public PedidoPK(String idCliente, String coditoPedido) {
		super();
		this.idCliente = idCliente;
		this.coditoPedido = coditoPedido;
	}
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getCoditoPedido() {
		return coditoPedido;
	}

	public void setCoditoPedido(String coditoPedido) {
		this.coditoPedido = coditoPedido;
	}

}
