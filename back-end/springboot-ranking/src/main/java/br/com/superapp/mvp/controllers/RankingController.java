package br.com.superapp.mvp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.superapp.mvp.model.entity.Ranking;
import br.com.superapp.mvp.service.IRankingService;

@RestController
public class RankingController {

	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IRankingService rankingService;


	@GetMapping("/ranking")
	public List<Ranking> listar(){
		return rankingService.findAll().stream().map( ranking -> {
			ranking.setPort(port);
			return ranking;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/detalhes-usuario/{id}")
	public Ranking detalle(@PathVariable Long id) {
		Ranking ranking = rankingService.findById(id);
		ranking.setPort(port);
		return ranking;
	}
}
