package br.com.superapp.mvp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.superapp.mvp.model.entity.Home;
import br.com.superapp.mvp.service.IHomeService;

@RestController
public class HomeController {

	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IHomeService homeService;


	@GetMapping("/home")
	public List<Home> listar(){
		return homeService.findAll().stream().map( home -> {
			home.setPort(port);
			return home;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/home-usuario/{id}")
	public Home buscar(@PathVariable Long id) {
		Home home = homeService.findById(id);
		home.setPort(port);
		return home;
	}
}
