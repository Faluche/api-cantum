package io.faluche.cantum.controller;

import io.faluche.cantum.model.PaillardeModel;
import io.faluche.cantum.service.PaillardeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RestController
@RequestMapping("/api/paillardes")
public class PaillardeController {
    private final PaillardeService paillardeService;

    public PaillardeController(PaillardeService paillardeService) {
        this.paillardeService = paillardeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPaillarde(@RequestBody PaillardeModel paillardeModel) {
        paillardeService.createPaillarde(paillardeModel);
    }

    @GetMapping()
    public ResponseEntity<List<PaillardeModel>> getAllPaillardes() {
        return ResponseEntity.ok(paillardeService.findAllPaillardes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaillardeModel> getPaillardeById(@PathVariable Long id) {
        return ResponseEntity.ok((PaillardeModel) paillardeService.findOnePaillardeById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePaillarde(@PathVariable Long id, @RequestBody PaillardeModel paillardeModel) {
        paillardeService.updateOnePaillardeById(id, paillardeModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePaillarde(@PathVariable @RequestBody Long id){
        paillardeService.deleteOnePaillardeById(id);
    }
}
