package io.faluche.cantum.service;

import io.faluche.cantum.entity.PaillardeEntity;
import io.faluche.cantum.model.PaillardeDto;
import io.faluche.cantum.repository.PaillardeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaillardeService {

    private final PaillardeRepository paillardeRepository;

    public PaillardeService(PaillardeRepository paillardeRepository) {
        this.paillardeRepository = paillardeRepository;
    }

    public List<PaillardeDto> getAllPaillardesWithParams(String title, String version) {
        List<PaillardeEntity> paillardes = paillardeRepository.findAll();
        return paillardes.stream()
                .map(PaillardeDto::entityToDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public PaillardeDto getPaillardeById(Long id) {
        Optional<PaillardeEntity> paillarde = paillardeRepository.findById(id);
        return paillarde.map(PaillardeDto::entityToDto).orElse(null);
    }
}