package es.nextdigital.demo.model;

public class ActivarTarjetaRequest {
	private String numeroTarjeta;

	
	public ActivarTarjetaRequest() {
		super();
	}

	public ActivarTarjetaRequest(String numeroTarjeta) {
		super();
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

}
