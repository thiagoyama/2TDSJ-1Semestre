package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.FuncionarioDao;
import br.com.fiap.jpa.entity.Funcionario;
import br.com.fiap.jpa.exception.CommitException;

public class FuncionarioDaoImpl implements FuncionarioDao {

	private EntityManager em;
	
	public FuncionarioDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Funcionario funcionario) {
		em.persist(funcionario);
	}

	public void atualizar(Funcionario funcionario) {
		em.merge(funcionario);
	}

	public void remover(Integer id) {
		Funcionario funcionario = pesquisar(id);
		em.remove(funcionario);
	}

	public Funcionario pesquisar(Integer id) {
		//validar se o funcionario existe, se não lançar uma exception
		
		return em.find(Funcionario.class, id);
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			em.getTransaction().rollback();
			//lançar uma exception
			throw new CommitException();
		}
	}

}
