package br.com.superapp.mvp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.superapp.mvp.model.dao.RankingDAO;
import br.com.superapp.mvp.model.entity.Ranking;

@Service
public class RankingServiceImpl implements IRankingService{
	
	@Autowired
	private RankingDAO rankingDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Ranking> findAll() {
		
		return (List<Ranking>)rankingDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Ranking findById(Long id) {
		
		return rankingDAO.findById(id).orElse(null);
	}

}
