package br.com.jpa.loja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "T_LOJA_MEDIDA_FEMININA")
@PrimaryKeyJoinColumn(name = "cd_medida")
public class MedidaFeminina extends Medida{
	@Column(name = "vl_busto")
	private double busto;

	@Column(name = "vl_sutia")
	private double sutia;

	@OneToOne(mappedBy = "medida")
	private Mulher mulher;

	public double getBusto() {
		return busto;
	}

	public void setBusto(double busto) {
		this.busto = busto;
	}

	public double getSutia() {
		return sutia;
	}

	public void setSutia(double sutia) {
		this.sutia = sutia;
	}

	public Mulher getMulher() {
		return mulher;
	}

	public void setMulher(Mulher mulher) {
		this.mulher = mulher;
	}
}
