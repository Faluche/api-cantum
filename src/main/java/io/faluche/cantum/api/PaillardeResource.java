package io.faluche.cantum.api;

import io.faluche.cantum.model.PaillardeDto;
import io.faluche.cantum.service.PaillardeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paillardes")
public class PaillardeResource {

    private final PaillardeService paillardeService;

    public PaillardeResource(PaillardeService paillardeService) {
        this.paillardeService = paillardeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<PaillardeDto> getPaillardesWithParams(@RequestParam(required = false) String title, @RequestParam(required = false) String version) {
        return paillardeService.getAllPaillardesWithParams(title, version);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public PaillardeDto getPaillardeById(@PathVariable() Long id) {
        return paillardeService.getPaillardeById(id);
    }


}
