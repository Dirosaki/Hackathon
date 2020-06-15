package br.com.superapp.mvp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.superapp.mvp.model.dao.PostoDAO;
import br.com.superapp.mvp.model.entity.Posto;

@Service
public class PostoServiceImpl implements IPostoService{
	
	@Autowired
	private PostoDAO postoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Posto> findAll() {
		
		return (List<Posto>)postoDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Posto findById(Long id) {
		
		return postoDAO.findById(id).orElse(null);
	}

	@Override
	public Posto findByLatitudeAndLongitude(Long lat, Long lon) {
		return postoDAO.findByLatitudeAndLongitude(lat, lon).orElse(null);
	}


}
