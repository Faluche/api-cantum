package io.faluche.cantum.service;

import io.faluche.cantum.entity.TitreEntity;
import io.faluche.cantum.model.TitreDto;
import io.faluche.cantum.repository.TitreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitreService {
    private final TitreRepository titreRepository;

    public TitreService(TitreRepository titreRepository) {
        this.titreRepository = titreRepository;
    }

    public List<TitreDto> getAllTitresWithParams(String nom) {
        List<TitreEntity> paillardes = nom == null
                ? titreRepository.findAll()
                : titreRepository.findAllByNom(nom);

        return paillardes.stream()
                .map(TitreDto::entityToDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    // TODO : Gérer les champs redondants
    public void createTitre(TitreDto titreDto) {
        TitreEntity titre = TitreEntity.builder()
                .nom(titreDto.getNom())
                .build();
        titre.setCreerPar("FALDIJPSYE03"); // FIXME not mapped
        titre.setModifierPar("FALDIJPSYE03");
        titre.setDateCreation(new Date());
        titre.setDateModification(new Date());
        titreRepository.save(titre);
    }
}
