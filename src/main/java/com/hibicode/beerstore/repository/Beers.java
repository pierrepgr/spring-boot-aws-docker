package com.hibicode.beerstore.repository;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.model.BeerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Beers extends JpaRepository<Beer, Long> {

    public Optional<Beer> findByNameAndType(String name, BeerType type);
}
