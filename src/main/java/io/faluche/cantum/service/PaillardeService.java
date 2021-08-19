package io.faluche.cantum.service;

import io.faluche.cantum.exception.PaillardeNotFoundException;
import io.faluche.cantum.model.PaillardeModel;
import io.faluche.cantum.repository.PaillardeRepository;
import io.faluche.cantum.repository.domain.Paillarde;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaillardeService {
    private final PaillardeRepository paillardeRepository;

    public PaillardeService(PaillardeRepository paillardeRepository) {
        this.paillardeRepository = paillardeRepository;
    }

    public void createPaillarde(PaillardeModel paillardeModel) {
        Paillarde paillarde = mapModelToPaillarde(paillardeModel);
        paillardeRepository.save(paillarde);
    }

    public List<PaillardeModel> findAllPaillardes() {
        List<Paillarde> paillardes = paillardeRepository.findAll();
        return paillardes
                .stream()
                .map(this::mapPaillardeToModel)
                .collect(Collectors.toList());
    }

    public Object findOnePaillardeById(Long id) {
        Paillarde paillarde = paillardeRepository.findById(id)
                .orElseThrow(() -> new PaillardeNotFoundException(id.toString()));
        return mapPaillardeToModel(paillarde);
    }

    public void updateOnePaillardeById(Long id, PaillardeModel paillardeModel) {
        Optional<Paillarde> paillarde = paillardeRepository.findById(id);
        if (!paillarde.isPresent()) {
            throw new PaillardeNotFoundException("");
        }
        Paillarde paillardeToSave = Paillarde.builder()
                .id(paillarde.get().getId())
                .title(paillardeModel.getTitle())
                .text(paillardeModel.getText())
                .build();
        paillardeRepository.save(paillardeToSave);
    }

    public void deleteOnePaillardeById(Long id) {
        paillardeRepository.deleteById(id);
    }

    private PaillardeModel mapPaillardeToModel(Paillarde paillarde) {
        PaillardeModel paillardeModel = new PaillardeModel();
        paillardeModel.setId(paillarde.getId());
        paillardeModel.setTitle(paillarde.getTitle());
        paillardeModel.setText(paillarde.getText());
        return paillardeModel;
    }


    private Paillarde mapModelToPaillarde(PaillardeModel paillardeModel) {
        Paillarde paillarde = new Paillarde();
        paillarde.setTitle(paillardeModel.getTitle());
        paillarde.setText(paillardeModel.getText());
        return paillarde;
    }
}
