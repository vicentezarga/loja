package br.com.loja.negocio.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name = "categorias")
public class Categoria {

	@Id
	@SequenceGenerator(name = "coseqCategoria", 
		allocationSize = 10, initialValue = 1, sequenceName = "seq_" + "categoria")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coseqCategoria")
	private long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy = "categoria")
	private List<Produto> colecaoProdutos;

	public Categoria(String nome, Status status, List<Produto> pcolecaoProdutos) {
		super();
		this.nome = nome;
		this.status = status;
		this.colecaoProdutos = pcolecaoProdutos;
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Categoria() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Produto> getColecaoProdutos() {
		return colecaoProdutos;
	}

	public void setColecaoProdutos(List<Produto> colecaoProdutos) {
		this.colecaoProdutos = colecaoProdutos;
	}

}
