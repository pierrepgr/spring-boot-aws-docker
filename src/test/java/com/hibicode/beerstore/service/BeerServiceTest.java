package com.hibicode.beerstore.service;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.model.BeerType;
import com.hibicode.beerstore.service.exception.BeerAlreadyExistException;
import org.junit.Test;

import java.math.BigDecimal;

public class BeerServiceTest {

    @Test(expected = BeerAlreadyExistException.class)
    public void should_deny_creation_of_beer_that_exists() {
        BeerService beerService = new BeerService();
        Beer beer = new Beer();
        beer.setName("Heineken");
        beer.setType(BeerType.LAGER);
        beer.setVolume(new BigDecimal("355"));
        beerService.save(beer);
    }
}
