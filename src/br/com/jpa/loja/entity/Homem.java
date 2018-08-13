package br.com.jpa.loja.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_LOJA_PESSOA_HOMEM")
@PrimaryKeyJoinColumn(name = "cd_pessoa")
public class Homem extends Pessoa {
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_COD_HOMEM_MEDIDA_MASCULINA")
	private MedidaMasculina medida;

	public MedidaMasculina getMedida() {
		return medida;
	}

	public void setMedida(MedidaMasculina medida) {
		this.medida = medida;
	}
}
