package br.com.superapp.mvp.service;

import java.util.List;

import br.com.superapp.mvp.model.entity.Telemedicina;

public interface ITelemedicinaService {
	
	public List<Telemedicina> findAll();
	
	public Telemedicina findById(Long id);

}
