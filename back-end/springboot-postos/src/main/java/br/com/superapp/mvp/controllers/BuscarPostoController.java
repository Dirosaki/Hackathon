package br.com.superapp.mvp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.superapp.mvp.model.entity.Posto;
import br.com.superapp.mvp.service.IPostoService;

@RestController
public class BuscarPostoController {

	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IPostoService postoService;


	@GetMapping("/postos")
	public List<Posto> listar(){
		return postoService.findAll().stream().map( postos -> {
			postos.setPort(port);
			return postos;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/detalhes-posto/{id}")
	public Posto detalhe(@PathVariable Long id) {
		Posto posto = postoService.findById(id);
		posto.setPort(port);
		return posto;
	}
	
	@GetMapping("/buscar-coordenada-posto/{lat}/{long}")
	public Posto buscarCoordenada(@PathVariable Long lat, @PathVariable Long lon) {
		Posto posto = postoService.findByLatitudeAndLongitude(lat, lon);
		posto.setPort(port);
		return posto;
	}
	

}
