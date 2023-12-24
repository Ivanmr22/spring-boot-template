package es.nextdigital.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarjeta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numeroTarjeta;
	
	private String pin;
	
	private boolean isCredito;
	
	@ManyToOne
	@JoinColumn(name = "idCuenta")
	private Cuenta cuentaAsociada;

	public Tarjeta() {
		super();
	}

	public Tarjeta(Long id, String numeroTarjeta, String pin, boolean isCredito, Cuenta cuentaAsociada) {
		super();
		this.id = id;
		this.numeroTarjeta = numeroTarjeta;
		this.pin = pin;
		this.isCredito = isCredito;
		this.cuentaAsociada = cuentaAsociada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public boolean isCredito() {
		return isCredito;
	}

	public void setCredito(boolean isCredito) {
		this.isCredito = isCredito;
	}

	public Cuenta getCuentaAsociada() {
		return cuentaAsociada;
	}

	public void setCuentaAsociada(Cuenta cuentaAsociada) {
		this.cuentaAsociada = cuentaAsociada;
	}

}
