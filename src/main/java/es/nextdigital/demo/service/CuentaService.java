package es.nextdigital.demo.service;

import java.util.ArrayList;
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
		
		Optional<Tarjeta> tarjetaEncontrada = tarjetaRepository.findByNumeroTarjeta(numeroTarjeta);
		
		if(tarjetaEncontrada.isPresent()) {
			
			Tarjeta tarjeta = tarjetaEncontrada.get();
			Cuenta cuentaAsociada = tarjeta.getCuentaAsociada();
			cuentaAsociada.setSaldo(cuentaAsociada.getSaldo() - cantidad);
			repository.save(cuentaAsociada);
			
			Movimiento nuevoMovimiento = new Movimiento(null, cantidad, "RETIRADA", cuentaAsociada);
			movimientoRepository.save(nuevoMovimiento);
		}
				
		return;
	}
}
