package br.com.fiap.unidades.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.unidades.dto.request.ChefeRequest;
import br.com.fiap.unidades.dto.response.ChefeResponse;
import br.com.fiap.unidades.entity.Chefe;
import br.com.fiap.unidades.service.ChefeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/chefe")
public class ChefeResource implements ResourceDTO<ChefeRequest, ChefeResponse> {

        @Autowired
        private ChefeService service;

        @GetMapping
        public ResponseEntity<Collection<ChefeResponse>> findAll(
                        @RequestParam(name = "usuarioId", required = false) Long usuarioId,
                        @RequestParam(name = "substituto", required = false) Boolean substituto,
                        @RequestParam(name = "unidadeId", required = false) Long unidadeId) {
                var chefe = Chefe.builder()
                                // .usuarioId(usuarioId)
                                .substituto(substituto)
                                // .unidadeId(unidadeId)
                                .build();

                ExampleMatcher matcher = ExampleMatcher
                                .matchingAll()
                                .withIgnoreNullValues()
                                .withIgnoreCase();

                Example<Chefe> example = Example.of(chefe, matcher);

                var encontrados = service.findAll(example);
                var resposta = encontrados.stream()
                                .map(service::toResponse)
                                .collect(Collectors.toList());
                return ResponseEntity.ok(resposta);
        }

        @GetMapping("/{id}")
        public ResponseEntity<ChefeResponse> findById(@PathVariable Long id) {
                var encontrado = service.findById(id);
                var resposta = service.toResponse(encontrado);
                return ResponseEntity.ok(resposta);
        }

        @Transactional
        @PostMapping
        public ResponseEntity<ChefeResponse> save(@RequestBody @Valid ChefeRequest request) {
                var entity = service.toEntity(request);
                var saved = service.save(entity);
                var resposta = service.toResponse(saved);

                var uri = ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/{id}")
                                .buildAndExpand(saved.getId())
                                .toUri();

                return ResponseEntity.created(uri).body(resposta);
        }
}
