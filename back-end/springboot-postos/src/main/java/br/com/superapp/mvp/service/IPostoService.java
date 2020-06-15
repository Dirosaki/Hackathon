package br.com.superapp.mvp.service;

import java.util.List;

import br.com.superapp.mvp.model.entity.Posto;

public interface IPostoService {
	
	public List<Posto> findAll();
	
	public Posto findById(Long id);
	
	public Posto findByLatitudeAndLongitude(Long lat, Long lon);

}
