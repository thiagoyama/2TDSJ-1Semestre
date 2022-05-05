package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDao;
import br.com.fiap.entity.Pacote;

public class PacoteDaoImpl extends GenericDaoImpl<Pacote,Integer> implements PacoteDao{

	public PacoteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Pacote> listar() {
		//Criar a query
		TypedQuery<Pacote> query = em.createQuery("from Pacote", Pacote.class);
		//Executar a query
		return query.getResultList();
	}

	public List<Pacote> buscarPorPrecoMaior(Float preco) {
		//Criar a query
		TypedQuery<Pacote> query =
			em.createQuery("from Pacote p where p.preco > :churros",Pacote.class);
		//Setar o parâmetro na query
		query.setParameter("churros", preco);
		//Executar a query
		return query.getResultList();
	}

}
