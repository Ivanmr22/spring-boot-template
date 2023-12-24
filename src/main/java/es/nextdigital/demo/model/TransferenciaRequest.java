package es.nextdigital.demo.model;

public class TransferenciaRequest {
	private String numeroTarjeta;
	private double cantidad;
	private String IBANDestino;

	public TransferenciaRequest(String numeroTarjeta, double cantidad, String IBANDestino) {
		super();
		this.numeroTarjeta = numeroTarjeta;
		this.cantidad = cantidad;
		this.IBANDestino = IBANDestino;
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

	public String getIBANDestino() {
		return IBANDestino;
	}

	public void setIBANDestino(String iBANDestino) {
		IBANDestino = iBANDestino;
	}

}
