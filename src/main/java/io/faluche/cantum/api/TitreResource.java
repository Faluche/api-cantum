package io.faluche.cantum.api;

import io.faluche.cantum.model.TitreDto;
import io.faluche.cantum.service.TitreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/titres")
public class TitreResource {

    private final TitreService titreService;

    public TitreResource(TitreService titreService) {
        this.titreService = titreService;
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<TitreDto> getAllTitresWithParams(@RequestParam(required = false) String nom) {
        return titreService.getAllTitresWithParams(nom);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTitre(@RequestBody TitreDto titre) {
        titreService.createTitre(titre);
    }
}
