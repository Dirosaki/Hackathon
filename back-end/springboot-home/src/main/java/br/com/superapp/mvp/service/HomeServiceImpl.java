package br.com.superapp.mvp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.superapp.mvp.model.dao.HomeDAO;
import br.com.superapp.mvp.model.entity.Home;

@Service
public class HomeServiceImpl implements IHomeService{
	
	@Autowired
	private HomeDAO rankingDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Home> findAll() {
		
		return (List<Home>)rankingDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Home findById(Long id) {
		
		return rankingDAO.findById(id).orElse(null);
	}

}
