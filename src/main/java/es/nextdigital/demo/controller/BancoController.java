package es.nextdigital.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.nextdigital.demo.model.Movimiento;
import es.nextdigital.demo.service.CuentaService;

@RestController
@RequestMapping("/banco")
public class BancoController {
	
	private CuentaService cuentaService;
	
	@Autowired
	public BancoController(CuentaService cuentaService) {
		super();
		this.cuentaService = cuentaService;
	}

	/*
	 * TODO -> Faltaría:
	 * - validar que el cliente (tarjeta) que está haciendo la consulta esté consultando por una de sus cuentas (IBAN)
	 * - validar que tiene activada la tarjeta
	 */
	@GetMapping("/movimientos/{IBAN}")
	public List<Movimiento> consultarMovimientos(@PathVariable String IBAN) {
		return cuentaService.obtenerMovimientos(IBAN);
	}

	@PostMapping("/retirada")
	public void sacarDinero() {
		return;
	}

	@PostMapping("/ingreso")
	public void ingresarDinero() {
		return;
	}

	@PostMapping("/transferencia")
	public void realizarTransferencia() {
		return;
	}

	@PostMapping("/activacionTarjeta")
	public void activarTarjeta() {
		return;
	}

	@PostMapping("/cambioPIN")
	public void cambiarPIN() {
		return;
	}
}
