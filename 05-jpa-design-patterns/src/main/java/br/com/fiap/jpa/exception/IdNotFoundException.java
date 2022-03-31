package br.com.fiap.jpa.exception;

public class IdNotFoundException extends Exception {

	public IdNotFoundException() {
		super("Id n�o existe");
	}
	
	public IdNotFoundException(String msg) {
		super(msg);
	}
	
}