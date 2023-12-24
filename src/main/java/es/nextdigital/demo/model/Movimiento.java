package es.nextdigital.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Movimiento {
	
	@Id
	private Long id;
	
	private double cantidad;
	
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "idCuenta")
	private Cuenta cuenta;

	public Movimiento() {
		super();
	}

	public Movimiento(Long id, double cantidad, String tipo, Cuenta cuenta) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.tipo = tipo;
		this.cuenta = cuenta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
}
