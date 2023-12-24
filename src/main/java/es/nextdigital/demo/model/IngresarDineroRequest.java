package es.nextdigital.demo.model;

public class IngresarDineroRequest {
	private String numeroTarjeta;
	private double cantidad;

	public IngresarDineroRequest(String numeroTarjeta, double cantidad) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.cantidad = cantidad;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
}
