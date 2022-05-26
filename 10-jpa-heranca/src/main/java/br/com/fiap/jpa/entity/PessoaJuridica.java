package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//SINGLE_TABLE
//@DiscriminatorValue("PJ")

//JOINED e TABLE_PER_CLASS
@Table(name="TB_PESSOA_JURIDICA")
@Entity
public class PessoaJuridica extends Pessoa {
	
	@Column(name="nr_cnpj")
	private String cnpj;
	
	@Column(name="st_ativo")
	private Boolean ativo;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
