package br.com.jpa.loja.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_LOJA_PESSOA_MULHER")
@PrimaryKeyJoinColumn(name = "cd_pessoa")
public class Mulher extends Pessoa{
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_COD_MULHER_MEDIDA_FEMININA")
	private MedidaFeminina medida;

	public MedidaFeminina getMedida() {
		return medida;
	}

	public void setMedida(MedidaFeminina medida) {
		this.medida = medida;
	}
}
