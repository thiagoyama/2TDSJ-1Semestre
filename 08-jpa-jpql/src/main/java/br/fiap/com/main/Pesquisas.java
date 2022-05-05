package br.fiap.com.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PacoteDao;
import br.com.fiap.dao.impl.PacoteDaoImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisas {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o PacoteDao
		PacoteDao pacoteDao = new PacoteDaoImpl(em);
		
		//Pesquisar por todos os pacotes e armazenar em uma lista
		//List<Pacote> lista = pacoteDao.listar();
		List<Pacote> lista = pacoteDao.buscarPorPrecoMaior(2000f);
		
		//Percorrer a lista de pacotes e exibir a descrição dos pacotes
		for (Pacote item : lista) {
			System.out.println(item.getDescricao() + " " + item.getPreco());
		}
		
	}//main
}//class
