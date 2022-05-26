package br.com.fiap.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//SINGLE_TABLE
//@DiscriminatorColumn(name="ds_tipo") //nome da coluna que define o tipo de objeto armazenado
//@DiscriminatorValue("P") //valor que será gravado, quando for do tipo Pessoa

@Entity
@Table(name="TB_PESSOA")
@SequenceGenerator(name="pessoa", sequenceName = "SQ_TB_PESSOA", allocationSize = 1)
public class Pessoa {
	
	@Id
	@Column(name="cd_pessoa")
	@GeneratedValue(generator = "pessoa", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_pessoa")
	private String nome;
	
	@CreationTimestamp //Cria a data automáticamente no insert
	@Column(name="dt_cadastro")
	private LocalDateTime dataCadastro;

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

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
