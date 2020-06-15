package br.com.superapp.mvp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.superapp.mvp.model.dao.TelemedicinaDAO;
import br.com.superapp.mvp.model.entity.Telemedicina;

@Service
public class TelemedicinaServiceImpl implements ITelemedicinaService{
	
	@Autowired
	private TelemedicinaDAO telemedicinaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Telemedicina> findAll() {
		
		return (List<Telemedicina>)telemedicinaDAO.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Telemedicina findById(Long id) {
		
		return telemedicinaDAO.findById(id).orElse(null);
	}

}
