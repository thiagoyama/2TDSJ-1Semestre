package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Funcionario;
import br.com.fiap.jpa.exception.CommitException;

public interface FuncionarioDao {

	void cadastrar(Funcionario funcionario);
	
	void atualizar(Funcionario funcionario);
	
	void remover(Integer id);
	
	Funcionario pesquisar(Integer id);
	
	void commit() throws CommitException;
	
}
