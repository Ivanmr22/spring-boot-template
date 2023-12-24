package es.nextdigital.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.nextdigital.demo.model.Cuenta;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
	Optional<Cuenta> findByIBAN(String IBAN);
}
