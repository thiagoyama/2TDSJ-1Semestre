package br.com.fiap.jpa.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ConsultaDao;
import br.com.fiap.jpa.dao.MedicoDao;
import br.com.fiap.jpa.dao.PacienteDao;
import br.com.fiap.jpa.dao.impl.ConsultaDaoImpl;
import br.com.fiap.jpa.dao.impl.MedicoDaoImpl;
import br.com.fiap.jpa.dao.impl.PacienteDaoImpl;
import br.com.fiap.jpa.entity.Consulta;
import br.com.fiap.jpa.entity.Medico;
import br.com.fiap.jpa.entity.Paciente;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Main {
	
	//Cadastrar todas as entidades (paciente, medico, consulta)
	public static void main(String[] args) {
		//Instanciar um médico
		Medico medico = new Medico();
		medico.setNome("Dr. Drauzio");
		medico.setCrm(546464);
		medico.setSalario(new BigDecimal("100000"));
		medico.setNumeroConta(1564654);
		
		//Instanciar um Paciente
		Paciente paciente = new Paciente();
		paciente.setNome("Guilherme Marciel");
		paciente.setDataNascimento(LocalDate.of(2000, 12, 15));
		
		//Instanciar uma Consulta
		Consulta consulta = new Consulta();
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		consulta.setData(LocalDateTime.of(2023, 1, 20, 10, 0));
		consulta.setCodigo(0); //bug
		
		//Obter a Fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		//Obter o Entity Manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o DAO do médico, consulta e paciente
		MedicoDao medicoDao = new MedicoDaoImpl(em);
		PacienteDao pacienteDao = new PacienteDaoImpl(em);
		ConsultaDao consultaDao = new ConsultaDaoImpl(em);
		
		//Cadastrar o médico
		medicoDao.cadastrar(medico);
		//Cadastrar o paciente
		pacienteDao.cadastrar(paciente);
		//Cadastrar a consulta
		consultaDao.cadastrar(consulta);
		//Commit
		try {
			consultaDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		//Sucesso!
	}
}
