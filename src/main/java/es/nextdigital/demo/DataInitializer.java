package es.nextdigital.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.nextdigital.demo.model.Cuenta;
import es.nextdigital.demo.model.Movimiento;
import es.nextdigital.demo.repository.CuentaRepository;
import es.nextdigital.demo.repository.MovimientoRepository;

@Component
public class DataInitializer implements ApplicationRunner {

    private final CuentaRepository cuentaRepository;
    private final MovimientoRepository movimientoRepository;

    @Autowired
    public DataInitializer(CuentaRepository cuentaRepository, MovimientoRepository movimientoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Cuenta cuenta1 = new Cuenta(1L, "ES9121000418450200051332", 0);
        cuentaRepository.save(cuenta1);
        
        Movimiento mov1 = new Movimiento(1L, 20, "INGRESO", cuenta1);
        movimientoRepository.save(mov1);
    }
}