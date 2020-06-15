package br.com.superapp.mvp.model.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.superapp.mvp.model.entity.Ranking;

public interface RankingDAO extends CrudRepository<Ranking, Long>{

}
