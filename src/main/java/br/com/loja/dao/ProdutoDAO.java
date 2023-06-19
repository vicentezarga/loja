package br.com.loja.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.loja.negocio.model.Produto;

public class ProdutoDAO implements IProdutoDAO {

	private EntityManager em;
	private EntityTransaction tx;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(Produto pProduto) {
		tx = em.getTransaction();
		if (!tx.isActive()) {
			tx.begin();
		}
		em.persist(pProduto);
	}

	@Override
	public void remover(long idProduto) {

		Produto produto = em.find(Produto.class, idProduto);
		tx = em.getTransaction();
		tx.begin();
		em.remove(produto);

	}

	@Override
	public void atualizarProduto(Produto pProduto) {

		Produto protudoAtualizado = em.merge(pProduto);

		protudoAtualizado.setNome(pProduto.getNome());
		protudoAtualizado.setDescricao(pProduto.getDescricao());
		protudoAtualizado.setDataCadastro(pProduto.getDataCadastro());
		protudoAtualizado.setPreco(pProduto.getPreco());
		protudoAtualizado.setCategoria(pProduto.getCategoria());

		tx = em.getTransaction();
		tx.begin();

	}

	@Override
	public Produto consultarID(long id) {

		return em.find(Produto.class, id);
	}

	@Override
	public List<Produto> buscarTodos() {

		String jpql = "Select p from produtos p";

		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> buscarProdutoNome(String pNome) {

		String jpql = "Select p from produtos p where p.nome = :nome";

		return em.createQuery(jpql, Produto.class).setParameter("nome", pNome).getResultList();

	}

	public List<Produto> buscarProdutoNomeCategoria(String pNomeCategoria) {

		String jpql = "Select p from produtos p where p.categoria.nome = :nome";

		return em.createQuery(jpql, Produto.class).setParameter("nome", pNomeCategoria).getResultList();
	}

	public List<Produto> buscarProdutosCriteria(String nome, BigDecimal preco, LocalDateTime dataCadastro) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto>from = query.from(Produto.class);
		
		Predicate filtros = builder.and();
		
		if(nome!=null && !nome.trim().isEmpty()) {
			filtros = builder.and(filtros,builder.equal(from.get("nome"), nome));
		}
		if(preco!=null) {
			filtros = builder.and(filtros,builder.equal(from.get("preco"), preco));
		}
		if(dataCadastro!=null) {
			filtros = builder.and(filtros,builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		query.where(filtros);
		
		return em.createQuery(query).getResultList();
		
	}
}
