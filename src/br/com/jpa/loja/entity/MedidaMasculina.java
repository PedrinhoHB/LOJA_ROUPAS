package br.com.jpa.loja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_LOJA_MEDIDA_MASCULINA")
@PrimaryKeyJoinColumn(name = "cd_medida")
public final class MedidaMasculina extends Medida {
	@Column(name = "vl_peito")
	private double peito;

	@Column(name = "vl_manga")
	private double manga;

	@OneToOne(mappedBy = "medida")
	private Homem homem;

	public double getPeito() {
		return peito;
	}

	public void setPeito(double peito) {
		this.peito = peito;
	}

	public double getManga() {
		return manga;
	}

	public void setManga(double manga) {
		this.manga = manga;
	}

	public Homem getHomem() {
		return homem;
	}

	public void setHomem(Homem homem) {
		this.homem = homem;
	}
}
