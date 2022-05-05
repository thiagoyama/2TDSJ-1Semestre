package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pacote;

public interface PacoteDao extends GenericDao<Pacote,Integer>{
	
	List<Pacote> listar();
	
	//Buscar pacote por preço maior
	List<Pacote> buscarPorPrecoMaior(Float preco);

}
