package es.nextdigital.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.nextdigital.demo.model.Cuenta;
import es.nextdigital.demo.model.Movimiento;
import es.nextdigital.demo.model.Tarjeta;
import es.nextdigital.demo.repository.CuentaRepository;
import es.nextdigital.demo.repository.MovimientoRepository;
import es.nextdigital.demo.repository.TarjetaRepository;

@Service
public class CuentaService {

	private CuentaRepository repository;
	private MovimientoRepository movimientoRepository;
	private TarjetaRepository tarjetaRepository;

	@Autowired
	public CuentaService(CuentaRepository repository, MovimientoRepository movimientoRepository,
			TarjetaRepository tarjetaRepository) {
		super();
		this.repository = repository;
		this.movimientoRepository = movimientoRepository;
		this.tarjetaRepository = tarjetaRepository;
	}

	public List<Movimiento> obtenerMovimientos(String IBANCuenta) {

		Optional<Cuenta> cuentaEncontrada = repository.findByIBAN(IBANCuenta);

		if (cuentaEncontrada.isPresent()) {
//			List<String> movimientos = new ArrayList<>();
//			movimientos.add("mov 1");
			List<Movimiento> movimientos = movimientoRepository.findByCuenta(cuentaEncontrada.get());

			return movimientos;
		}

		return null;
	}

	public void sacarDinero(String numeroTarjeta, double cantidad) {
		realizarMovimiento(numeroTarjeta, cantidad, "RETIRADA");
	}

	public void ingresarDinero(String numeroTarjeta, double cantidad) {
		realizarMovimiento(numeroTarjeta, cantidad, "INGRESO");
	}

	public void realizarMovimiento(String numeroTarjeta, double cantidad, String tipo) {
		Optional<Tarjeta> tarjetaEncontrada = tarjetaRepository.findByNumeroTarjeta(numeroTarjeta);

		if (tarjetaEncontrada.isPresent()) {

			Tarjeta tarjeta = tarjetaEncontrada.get();
			Cuenta cuentaAsociada = tarjeta.getCuentaAsociada();
			cuentaAsociada.setSaldo(cuentaAsociada.getSaldo() + (tipo == "INGRESO" || tipo == "TRANSFERENCIA_ENTRANTE" ? cantidad : -(cantidad)));
			repository.save(cuentaAsociada);

			Movimiento nuevoMovimiento = new Movimiento(null, cantidad, tipo, cuentaAsociada);
			movimientoRepository.save(nuevoMovimiento);
		}

		return;
	}

	
	/*
	 * TODO -> Esto debería ser transaccional (si algo falla, se hace rollback de todo)
	 */
	public void realizarTransferencia(String numeroTarjeta, double cantidad, String ibanDestino) {
		
		realizarMovimiento(numeroTarjeta, cantidad, "TRANSFERENCIA_SALIENTE");
		
		
		if(isIBANInterno(ibanDestino)) {
			
			Optional<Cuenta> cuentaEncontrada = repository.findByIBAN(ibanDestino);
			
			if(cuentaEncontrada.isPresent()) {
				Cuenta cuenta = cuentaEncontrada.get();
				Movimiento nuevoMovimiento = new Movimiento(null, cantidad, "TRANSFERENCIA_ENTRANTE", cuenta);
				movimientoRepository.save(nuevoMovimiento);
				
				cuenta.setSaldo(cuenta.getSaldo() + cantidad);
				repository.save(cuenta);
			}
		} else {
			// TODO -> En este caso el banco se comunicaría con el banco del IBAN de destino para realizar la transferencia
		}
	}
	
	/**
	 * Evalua si el IBAN dado es un IBAN del banco propio o un IBAN de un banco externo
	 * 
	 * Por propositos de tiempo, devolveré true y suponemos que todas las transferencias son internas
	 */
	private boolean isIBANInterno(String IBAN) {
		return true;
	}
}
