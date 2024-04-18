package br.com.fiap.unidades.resource;

import br.com.fiap.unidades.dto.request.UnidadeRequest;
import br.com.fiap.unidades.dto.response.UnidadeResponse;
import br.com.fiap.unidades.entity.Unidade;
import br.com.fiap.unidades.service.UnidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/unidade")
public class UnidadeResource {

    @Autowired
    private UnidadeService service;

    @GetMapping
    public ResponseEntity<Collection<UnidadeResponse>> findAll(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "sigla", required = false) String sigla,
            @RequestParam(name = "macroId", required = false) Long macroId) {
        var unidade = Unidade.builder()
                .nome(nome)
                .sigla(sigla)
                .build();

        if (macroId != null) {
            // Se um ID de macro for fornecido, pesquise a unidade macro correspondente
            var macro = service.findById(macroId);
            unidade.setMacro(macro);
        }

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Unidade> example = Example.of(unidade, matcher);

        List<Unidade> encontrados = service.findAll(example);
        List<UnidadeResponse> resposta = encontrados.stream()
                .map(service::toResponse)
                .toList();

        return ResponseEntity.ok(resposta);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadeResponse> findById(@PathVariable Long id) {
        Unidade encontrado = service.findById(id);
        UnidadeResponse resposta = service.toResponse(encontrado);
        return ResponseEntity.ok(resposta);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<UnidadeResponse> save(@RequestBody @Valid UnidadeRequest request) {
        Unidade entity = service.toEntity(request);
        Unidade saved = service.save(entity);
        UnidadeResponse resposta = service.toResponse(saved);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(resposta);
    }
}
