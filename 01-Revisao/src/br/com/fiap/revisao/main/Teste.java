package br.com.fiap.revisao.main;

import br.com.fiap.revisao.model.Admin;
import br.com.fiap.revisao.model.Usuario;

public class Teste {

	//Criar o método main // main -> CTRL + Espaço
	public static void main(String[] args) {
		//Instanciar um Usuario
		Usuario user = new Usuario(1, "Vitoria", "22.543.643-49", 20 );
		
//		//Setar os valores para os atributos
//		user.setCpf("22.543.643-49");
//		user.setId(1);
//		user.setNome("Vitoria");
//		user.setIdade(14);
		
		//Chamar os métodos
		user.logar("123");
		System.out.println("Permissão: " + user.permissao());
		
		//Exibir os valores do objeto armazenado em user
		System.out.println(user);
		
		//Instanciar um Admin
		Admin adm = new Admin(2, "Victor", "32.343.643-59", 20, "victor@fiap.com.br" );
		adm.logar("123");
		System.out.println("Permissão admin: " + adm.permissao());
		
		//Exibir os valores do admin, Exibir o email do admin
		System.out.println(adm);
		
		//Admin adm2 = new Usuario(3,""); Não compila
		
		Usuario user2 = new Admin(3, "", "", 20, "");
		System.out.println("Permissão admin: " + user2.permissao()); //Admin
		
	}//main
}//class