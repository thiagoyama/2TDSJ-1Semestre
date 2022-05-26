package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GenericDao;
import br.com.fiap.jpa.dao.impl.GenericDaoImpl;
import br.com.fiap.jpa.entity.Pessoa;
import br.com.fiap.jpa.entity.PessoaFisica;
import br.com.fiap.jpa.entity.PessoaJuridica;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Main {

	public static void main(String[] args) {
		//Obter a fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		//Obter o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o DaoGenerico para a Pessoa
		GenericDao<Pessoa,Integer> dao = new GenericDaoImpl<Pessoa, Integer>(em) {};
		
		//Instanciar a pessoa
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Marcos");
		
		//Instanciar a pessoa fisica
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("Guilherme");
		pf.setCpf("13.546.654-88");
		pf.setRg("23.655.565-5");
		
		//Instanciar a pessoa juridica
		PessoaJuridica pj = new PessoaJuridica();
		pj.setNome("FIAP");
		pj.setAtivo(true);
		pj.setCnpj("45.564.654.0001-65");
		
		//Cadastrar as pessoas
		dao.cadastrar(pessoa);
		dao.cadastrar(pj);
		dao.cadastrar(pf);
		
		//Commit
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
	}
}