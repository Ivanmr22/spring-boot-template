package es.nextdigital.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cuenta {
	
	@Id
	private Long id;
	
	private String IBAN;
	
	private double saldo;

	public Cuenta() {
		super();
	}

	public Cuenta(Long id, String iBAN, double saldo) {
		super();
		this.id = id;
		IBAN = iBAN;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
