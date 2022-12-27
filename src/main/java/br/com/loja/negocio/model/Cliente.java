package br.com.loja.negocio.model;

import java.util.List;

import javax.persistence.Column;
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
	
	@Column(name = "CPF", nullable = false, unique = true, 
			length = 11, insertable = true, updatable = false)
	private String cpf;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> colecaoPedido;

	public Cliente() {
		super();
	}

	public Cliente(String cpf, String nome) {
		super();
		
		this.cpf = cpf;
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pedido> getColecaoPedido() {
		return colecaoPedido;
	}

	public void setColecaoPedido(List<Pedido> colecaoPedido) {
		this.colecaoPedido = colecaoPedido;
	}
}
