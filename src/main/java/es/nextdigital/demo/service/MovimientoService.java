package es.nextdigital.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.nextdigital.demo.model.Cuenta;
import es.nextdigital.demo.repository.CuentaRepository;
import es.nextdigital.demo.repository.MovimientoRepository;

@Service
public class MovimientoService {

	private CuentaRepository repository;
	private MovimientoRepository movimientoRepository;

	@Autowired
	public MovimientoService(CuentaRepository repository) {
		super();
		this.repository = repository;
	}
	
	public List<String> obtenerMovimientos(String IBANCuenta) {
		
		Optional<Cuenta> cuentaEncontrada = repository.findByIBAN(IBANCuenta);
		
		if(cuentaEncontrada.isPresent()) {
			List<String> movimientos = new ArrayList<>();
			movimientos.add("mov 1");
			
			return movimientos;
		}
		
		return null;
	}
}
