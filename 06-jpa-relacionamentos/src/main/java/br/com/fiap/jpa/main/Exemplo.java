package br.com.fiap.jpa.main;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.TecnicoDao;
import br.com.fiap.jpa.dao.TimeDao;
import br.com.fiap.jpa.dao.impl.TecnicoDaoImpl;
import br.com.fiap.jpa.dao.impl.TimeDaoImpl;
import br.com.fiap.jpa.entity.Tecnico;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo {

	//Cadastrar o tecnico e time
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		try {
			//Cadastrar o tecnico
			//Instanciar um técnico, sem o código e time (criar o construtor)
			Tecnico tecnico = new Tecnico("Vitor", LocalDate.of(1980, 1, 1), new BigDecimal("150000"));
			//Instanciar o TecnicoDao
			TecnicoDao tecnicoDao = new TecnicoDaoImpl(em);
			//Cadastrar e commit;
			//tecnicoDao.cadastrar(tecnico);
			//tecnicoDao.commit();
			
			//Cadastrar um time			
			//Instanciar um time, sem o código (criar o construtor)
			Time time = new Time(tecnico, "Noroeste", "Alfredo de castilho");
			//Instanciar o TimeDao
			TimeDao timeDao = new TimeDaoImpl(em);
			//Cadastrar e commit
			timeDao.cadastrar(time);
			timeDao.commit();
			
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		em.close();
		fabrica.close();
	}
	
}
