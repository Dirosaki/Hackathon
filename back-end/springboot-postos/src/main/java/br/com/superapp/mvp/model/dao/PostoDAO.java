package br.com.superapp.mvp.model.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.superapp.mvp.model.entity.Posto;

public interface PostoDAO extends CrudRepository<Posto, Long>{

	Optional<Posto> findByLatitudeAndLongitude(Long lat, Long lon);

}
