package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//JOINED e TABLE_PER_CLASS
@Table(name="TB_PESSOA_FISICA")

@Entity
public class PessoaFisica extends Pessoa {

	@Column(name="nr_cpf")
	private String cpf;
	
	@Column(name="nr_rg")
	private String rg;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
