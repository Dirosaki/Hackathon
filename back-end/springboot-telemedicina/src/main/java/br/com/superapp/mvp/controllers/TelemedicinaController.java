package br.com.superapp.mvp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.superapp.mvp.model.entity.Telemedicina;
import br.com.superapp.mvp.service.ITelemedicinaService;

@RestController
public class TelemedicinaController {

	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private ITelemedicinaService telemedicina;


	@GetMapping("/telemedicina")
	public List<Telemedicina> listar(){
		return telemedicina.findAll().stream().map( telemedicina -> {
			telemedicina.setPort(port);
			return telemedicina;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/busca-telemedicina/{id}")
	public Telemedicina detalle(@PathVariable Long id) {
		Telemedicina ranking = telemedicina.findById(id);
		ranking.setPort(port);
		return ranking;
	}
}
