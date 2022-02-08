package br.com.fiap.revisao.main;

import java.util.ArrayList;
import java.util.List;
import br.com.fiap.revisao.model.Usuario;

public class TesteColecao {

	public static void main(String[] args) {
		
		//Criar uma lista de Usuario
		List<Usuario> lista = new ArrayList<>();
		
		//Instanciar e adicionar o usuário na lista
		Usuario user1 = new Usuario(1, "João");
		lista.add(user1);

		//Instanciar o usuário e adicionar na lista
		lista.add(new Usuario(2, "Victor"));
		
		System.out.println("FOREACH");
		//Exibir os usuários da lista
		for (Usuario item : lista) {
			System.out.println(item);
		}

		System.out.println("FOR");
		//Quantidade de elementos da lista -> .size();
		for (int i=0; i < lista.size(); i++ ) {
			//Recupera o elemento da lista através do index
			System.out.println(lista.get(i));
		}
		
		//Criar um conjunto de String
		
		//Adicionar 3 estados (duas iguais)
		
		//Foreach para exibir os elementos do conjunto (Set)
		
		
		//Criar um mapa de Strings (Chave,Valor)
		
		//Adicionar na chave o estado (Sigla) e no valor a capital (3)
		
		//Recuperar o valor de uma chave específica
		
		
	}//main
}//class
