package io.faluche.cantum.service;

import io.faluche.cantum.entity.PaillardeEntity;
import io.faluche.cantum.model.PaillardeDto;
import io.faluche.cantum.repository.PaillardeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PaillardeService {

    private final PaillardeRepository paillardeRepository;

    public PaillardeService(PaillardeRepository paillardeRepository) {
        this.paillardeRepository = paillardeRepository;
    }

    public List<PaillardeDto> getAllPaillardes() {
        List<PaillardeEntity> paillardes = paillardeRepository.findAll();
        return paillardes.stream()
                .map(PaillardeDto::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}