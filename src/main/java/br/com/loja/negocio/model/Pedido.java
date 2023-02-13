package br.com.loja.negocio.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "vl_total")
	private BigDecimal vlTotal = BigDecimal.ZERO;

	@Column(name = "dt_pedido", updatable = false, insertable = true, nullable = false)
	private LocalDate dataPedido = LocalDate.now();

	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();

	public Pedido(LocalDate dataPedido, Cliente cliente) {
		
		this.dataPedido = dataPedido;
		this.cliente = cliente;
		
	}

	public Pedido() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void adicionarItem (ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		
		vlTotal = vlTotal.add(item.getValor());
	}
}
