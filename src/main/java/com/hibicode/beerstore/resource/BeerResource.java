package com.hibicode.beerstore.resource;

import com.hibicode.beerstore.model.Beer;
import com.hibicode.beerstore.repository.Beers;
import com.hibicode.beerstore.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/beers")
public class BeerResource {

    @Autowired
    private Beers beers;
    @Autowired
    private BeerService beerService;

    @GetMapping
    public List<Beer> all() {
        return this.beers.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Beer create(@RequestBody @Valid Beer beer) {
        return this.beerService.save(beer);
    }

    @PutMapping("/{id}")
    public Beer update(@RequestBody @Valid Beer beer, @PathVariable("id") Long id) {
        beer.setId(id);
        return this.beerService.save(beer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.beerService.delete(id);
    }
}
