package es.nextdigital.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.nextdigital.demo.model.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Long>{
	
	Optional<Tarjeta> findByNumeroTarjeta(String numeroTarjeta);
}
