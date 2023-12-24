package es.nextdigital.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.nextdigital.demo.model.ActivarTarjetaRequest;
import es.nextdigital.demo.model.IngresarDineroRequest;
import es.nextdigital.demo.model.Movimiento;
import es.nextdigital.demo.model.SacarDineroRequest;
import es.nextdigital.demo.model.TransferenciaRequest;
import es.nextdigital.demo.service.CuentaService;
import es.nextdigital.demo.service.TarjetaService;

@RestController
@RequestMapping("/banco")
public class BancoController {
	
	private CuentaService cuentaService;
	private TarjetaService tarjetaService;
	
	@Autowired
	public BancoController(CuentaService cuentaService, TarjetaService tarjetaService) {
		super();
		this.cuentaService = cuentaService;
		this.tarjetaService = tarjetaService;
	}

	/*
	 * TODO -> Faltaría:
	 * - validar que el cliente (tarjeta) que está haciendo la consulta esté consultando por una de sus cuentas (IBAN)
	 * - validar que tiene activada la tarjeta
	 * - lanzar error si el IBAN no existe
	 */
	@GetMapping("/movimientos/{IBAN}")
	public List<Movimiento> consultarMovimientos(@PathVariable String IBAN) {
		return cuentaService.obtenerMovimientos(IBAN);
	}

	/*
	 * TODO -> Faltaría:
	 * - Validar que no pueda retirar dinero si:
	 * 		- La cantidad a retirar es mayor al saldo que dispone, o sobrepasa el limite de crédito en caso de ser una tarjeta de credito
	 * - Lanzar error si el numero de tarjeta no existe
	 */
	@PostMapping("/retirada")
	public void sacarDinero(@RequestBody SacarDineroRequest request) {
		cuentaService.sacarDinero(request.getNumeroTarjeta(), request.getCantidad());
		
		return;
	}
	
	/*
	 * TODO -> Faltaría:
	 * - Validar que pueda realizar el ingreso solo si el cajero es del mismo banco. No se puede ingresar dinero desde cajeros de otras entidades.
	 * - Lanzar error si el numero de tarjeta no existe
	 */
	@PostMapping("/ingreso")
	public void ingresarDinero(@RequestBody IngresarDineroRequest request) {
		cuentaService.ingresarDinero(request.getNumeroTarjeta(), request.getCantidad());
		return;
	}

	/*
	 * TODO -> Faltaría:
	 * - Que no se pueda realizar la transferencia si no tiene suficiente saldo para hacerla
	 * - Mostrar error si el IBAN de destino no es válido
	 */
	@PostMapping("/transferencia")
	public void realizarTransferencia(@RequestBody TransferenciaRequest request) {
		cuentaService.realizarTransferencia(request.getNumeroTarjeta(), request.getCantidad(), request.getIBANDestino());
		return;
	}

	/*
	 * TODO -> Faltaría
	 * - Indicar que la tarjeta dada ya ha sido activada en caso de que ya lo esté
	 */
	@PostMapping("/activacionTarjeta")
	public void activarTarjeta(@RequestBody ActivarTarjetaRequest request) {
		tarjetaService.activarTarjeta(request.getNumeroTarjeta());
		return;
	}

	@PostMapping("/cambioPIN")
	public void cambiarPIN() {
		return;
	}
}
