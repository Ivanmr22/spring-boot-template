package es.nextdigital.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.nextdigital.demo.model.Tarjeta;
import es.nextdigital.demo.repository.TarjetaRepository;

@Service
public class TarjetaService {

	private TarjetaRepository repository;

	@Autowired
	public TarjetaService(TarjetaRepository repository) {
		super();
		this.repository = repository;
	}

	public void activarTarjeta(String numeroTarjeta) {
		Optional<Tarjeta> tarjeta = repository.findByNumeroTarjeta(numeroTarjeta);
		
		if(tarjeta.isPresent()) {
			tarjeta.get().setActiva(true);
			repository.save(tarjeta.get());
		}
		
		return;
	}

}
