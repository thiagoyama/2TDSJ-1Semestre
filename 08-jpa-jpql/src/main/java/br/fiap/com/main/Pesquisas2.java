package br.fiap.com.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.PacoteDao;
import br.com.fiap.dao.ReservaDao;
import br.com.fiap.dao.TransporteDao;
import br.com.fiap.dao.impl.ClienteDaoImpl;
import br.com.fiap.dao.impl.PacoteDaoImpl;
import br.com.fiap.dao.impl.ReservaDaoImpl;
import br.com.fiap.dao.impl.TransporteDaoImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisas2 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		// Instanciar o ClienteDao
		ClienteDao clienteDao = new ClienteDaoImpl(em);

		// Pesquisar por todos os clientes
		List<Cliente> clientes = clienteDao.buscarPorParteNome("A");

		// Exibir o nome dos clientes
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		//Contar a quantidade de clientes do estado do PR
		long qtd = clienteDao.contarPorEstado("PR");
		
		//Exibir a quantidade
		System.out.println("Quantidade de clientes por estado: " + qtd);
		
		//Instanciar o TransporteDao
		TransporteDao transporteDao = new TransporteDaoImpl(em);
		
		//Pesquisar o transporte pelo código (1)
		Transporte transporte = transporteDao.pesquisar(1);
		
		//Instanciar o PacoteDao
		PacoteDao pacoteDao = new PacoteDaoImpl(em);
		
		//Somar os preços dos pacotes pelo transporte
		double soma = pacoteDao.somarPrecosPorTransporte(transporte);
		
		//Exibir a soma
		System.out.println("Soma dos preços do pacote: " + soma);
		
		//Instanciar a ReservaDao
		ReservaDao reservaDao = new ReservaDaoImpl(em);
		
		//Pesquisar reserva por cpf do cliente (88892992922)
		List<Reserva> reservas = reservaDao.buscarPorCpf("88892992922");
		
		//Exibir a descrição do pacote da reserva
		for (Reserva r : reservas) {
			System.out.println(r.getPacote().getDescricao());
		}
		
		//Pesquisar pacotes por preço menor
		List<Pacote> pacotes = pacoteDao.buscarPorPrecoMenor(2000f);
		//Exibir a descrição e o preço
		for (Pacote p : pacotes) {
			System.out.println(p.getDescricao() + " " + p.getPreco());
		}
		
	}
}