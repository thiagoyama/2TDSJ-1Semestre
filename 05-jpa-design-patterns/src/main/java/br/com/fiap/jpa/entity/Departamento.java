package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_DEPARTAMENTO")
@SequenceGenerator(name="dep",sequenceName = "SQ_TB_DEPARTAMENTO", allocationSize = 1)
public class Departamento {

	@Id
	@Column(name="cd_departamento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep")
	private Integer codigo;
	
	@Column(name="nm_departamento", length = 40, nullable = false)
	private String nome;
	
	public Departamento() {}

	public Departamento(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
