package br.com.superapp.mvp.service;

import java.util.List;

import br.com.superapp.mvp.model.entity.Home;

public interface IHomeService {
	
	public List<Home> findAll();
	
	public Home findById(Long id);

}
