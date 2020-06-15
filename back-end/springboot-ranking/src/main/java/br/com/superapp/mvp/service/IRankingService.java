package br.com.superapp.mvp.service;

import java.util.List;

import br.com.superapp.mvp.model.entity.Ranking;

public interface IRankingService {
	
	public List<Ranking> findAll();
	
	public Ranking findById(Long id);

}
