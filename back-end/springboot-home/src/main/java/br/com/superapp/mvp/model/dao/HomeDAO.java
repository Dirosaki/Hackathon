package br.com.superapp.mvp.model.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.superapp.mvp.model.entity.Home;

public interface HomeDAO extends CrudRepository<Home, Long>{

}
