package br.com.fiap.jpa.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Genero;

public class ExemploCadastro {

	public static void main(String[] args) {
		//Obter um entity manager factory (fabrica)
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Obter um entity manager
		EntityManager em = fabrica.createEntityManager();
		
//		byte[] vetor = new byte[10];
//		vetor[0] = 1;
		
		//Criar um objeto Cliente, sem c�digo (estado novo)
		Cliente cliente = new Cliente("Rosalinda", new GregorianCalendar(1975, Calendar.APRIL, 9), 
				Genero.FEMININO, null, "321.312.545-98", "(11)89865656");
		
		//Chamar o m�todo persist
		em.persist(cliente);
		
		//Iniciar uma transa��o
		em.getTransaction().begin();
		
		//Finalizar a transa��o com o commit
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
}