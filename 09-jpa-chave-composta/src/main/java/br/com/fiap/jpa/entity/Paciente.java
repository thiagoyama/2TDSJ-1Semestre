package br.com.fiap.jpa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PACIENTE")
@SequenceGenerator(name="paciente", sequenceName = "SQ_TB_PACIENTE", allocationSize = 1)
public class Paciente {
	
	@Id
	@Column(name="cd_paciente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente")
	private Integer codigo;
	
	@Column(name="nm_paciente", length = 100, nullable = false)
	private String nome;
	
	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
