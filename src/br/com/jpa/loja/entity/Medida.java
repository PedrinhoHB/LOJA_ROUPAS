package br.com.jpa.loja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_LOJA_MEDIDA")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "medida", sequenceName = "SQ_T_DEM_LOJA_ROUPAS_MEDIDA", allocationSize = 1)
public abstract class Medida {
	@Id
	@Column(name = "cd_medida")
	@GeneratedValue(generator = "medida", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "vl_cintura")
	private double cintura;

	@Column(name = "vl_quadril")
	private double quadril;

	@Column(name = "vl_coxas")
	private double coxas;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getCintura() {
		return cintura;
	}

	public void setCintura(double cintura) {
		this.cintura = cintura;
	}

	public double getQuadril() {
		return quadril;
	}

	public void setQuadril(double quadril) {
		this.quadril = quadril;
	}

	public double getCoxas() {
		return coxas;
	}

	public void setCoxas(double coxas) {
		this.coxas = coxas;
	}
}
