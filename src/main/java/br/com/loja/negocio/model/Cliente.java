package br.com.loja.negocio.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Embedded
	private DadosPessoais dadospessoais;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> colecaoPedido;

	public Cliente() {
		super();
	}

	public Cliente(DadosPessoais pessoais) {
		super();
		this.dadospessoais = pessoais;

	}

	public DadosPessoais getDadospessoais() {
		return dadospessoais;
	}

	public void setDadospessoais(DadosPessoais dadospessoais) {
		this.dadospessoais = dadospessoais;
	}

	public List<Pedido> getColecaoPedido() {
		return colecaoPedido;
	}

	public void setColecaoPedido(List<Pedido> colecaoPedido) {
		this.colecaoPedido = colecaoPedido;
	}
}
