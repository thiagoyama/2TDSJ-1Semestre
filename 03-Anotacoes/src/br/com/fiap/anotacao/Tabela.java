package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //TYPE -> classe ou interface
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

	String nome();
	
}