package br.com.loja.negocio.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
	
	@Column(name = "CPF", nullable = false, unique = true, 
			length = 11, insertable = true, updatable = false)
	private String cpf;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	public DadosPessoais() {
		super();
	}

	public DadosPessoais(String cpf, String nome) {
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
}
