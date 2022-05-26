package br.com.fiap.jpa.entity;

import java.io.Serializable;

/***
 * Classe que mapeia a Chave composta da TB_CONSULTA
 * Possui os atributos que formam a chave
 * Implementa a Serializable
 * Possui os Getters e Setters, construtores e hashCode e equals 
 * @author logonpflocal
 *
 */
public class ConsultaPk implements Serializable {

	private Integer codigo;
	
	private Integer paciente;
	
	private Integer medico;
	
	
	//Gerar os métodos hashCode e equals, comparar ser dois objetos são iguais de 
	//acordo com os valores de seus atributos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaPk other = (ConsultaPk) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getPaciente() {
		return paciente;
	}

	public void setPaciente(Integer paciente) {
		this.paciente = paciente;
	}

	public Integer getMedico() {
		return medico;
	}

	public void setMedico(Integer medico) {
		this.medico = medico;
	}
	
}
