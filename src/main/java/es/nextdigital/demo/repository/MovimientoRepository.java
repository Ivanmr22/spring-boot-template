package es.nextdigital.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.nextdigital.demo.model.Cuenta;
import es.nextdigital.demo.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{
	List<Movimiento> findByCuenta(Cuenta Cuenta);
}
