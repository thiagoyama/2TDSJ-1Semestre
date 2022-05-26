package br.com.fiap.jpa.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//A classe Medico mapeia uma segunda tabela
@SecondaryTable(name="TB_MEDICO_FINANCEIRO")

@Entity
@Table(name="TB_MEDICO")
@SequenceGenerator(name="medico", sequenceName = "SQ_TB_MEDICO", allocationSize = 1)
public class Medico {

	@Id
	@Column(name="cd_medico")
	@GeneratedValue(generator = "medico", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="vl_salario", nullable = false, table = "TB_MEDICO_FINANCEIRO")
	private BigDecimal salario;
	
	@Column(name="nr_conta", nullable = false, table = "TB_MEDICO_FINANCEIRO")
	private Integer numeroConta;
	
	@Column(name="nm_medico", length = 100, nullable = false)
	private String nome;
	
	@Column(name="nr_crm", nullable = false)
	private Integer crm;

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

	public Integer getCrm() {
		return crm;
	}

	public void setCrm(Integer crm) {
		this.crm = crm;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
}
