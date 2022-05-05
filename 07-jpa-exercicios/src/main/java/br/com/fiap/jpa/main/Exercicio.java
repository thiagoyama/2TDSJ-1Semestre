package br.com.fiap.jpa.main;

import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exercicio {

	//Cadastrar as entidades relacionadas
	public static void main(String[] args) {
		//Instanciar o sistema com o nome
		
		//Instanciar o caso de teste com o nome, descrição e sistema
		
		//Instanciar o item de teste com a descrição e caso de teste
		
		//Instanciar um usuário com o nome e a lista de item de teste
		
		//Instanciar a fabrica e o entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Instanciar o UsuarioDao
		
		//Cadastrar o usuário, ajustar para o resto ser cadastrado em cascata
		
	}
}