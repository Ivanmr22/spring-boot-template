package es.nextdigital.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.nextdigital.demo.model.Cuenta;
import es.nextdigital.demo.model.Movimiento;
import es.nextdigital.demo.model.Tarjeta;
import es.nextdigital.demo.repository.CuentaRepository;
import es.nextdigital.demo.repository.MovimientoRepository;
import es.nextdigital.demo.repository.TarjetaRepository;

@Component
public class DataInitializer implements ApplicationRunner {

    private final CuentaRepository cuentaRepository;
    private final MovimientoRepository movimientoRepository;
    private final TarjetaRepository tarjetaRepository;

    @Autowired
    public DataInitializer(CuentaRepository cuentaRepository, MovimientoRepository movimientoRepository,
			TarjetaRepository tarjetaRepository) {
		super();
		this.cuentaRepository = cuentaRepository;
		this.movimientoRepository = movimientoRepository;
		this.tarjetaRepository = tarjetaRepository;
	}
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Cuenta cuenta1 = new Cuenta(1L, "ES9121000418450200051332", 20.0);
        cuentaRepository.save(cuenta1);
        
        Cuenta cuenta2 = new Cuenta(2L, "ES9121000418450200051333", 0);
        cuentaRepository.save(cuenta2);
        
        Movimiento mov1 = new Movimiento(1L, 20, "INGRESO", cuenta1);
        movimientoRepository.save(mov1);
        
        Tarjeta tarjeta1 = new Tarjeta(1L, "4556424242424242", "0000", false, cuenta1, true);
        tarjetaRepository.save(tarjeta1);
        
        Tarjeta tarjeta2 = new Tarjeta(2L, "4556424242424243", "0000", false, cuenta2, true);
        tarjetaRepository.save(tarjeta2);
    }
}