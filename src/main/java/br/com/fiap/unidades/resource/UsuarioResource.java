// package br.com.fiap.unidades.resource;

// import br.com.fiap.unidades.dto.request.UsuarioRequest;
// import br.com.fiap.unidades.dto.response.UsuarioResponse;
// import br.com.fiap.unidades.entity.Usuario;
// import br.com.fiap.unidades.service.UsuarioService;
// import jakarta.validation.Valid;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Example;
// import org.springframework.data.domain.ExampleMatcher;
// import org.springframework.http.ResponseEntity;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import java.util.Collection;

// @RestController
// @RequestMapping(value = "/usuario")
// public class UsuarioResource implements ResourceDTO<UsuarioRequest,
// UsuarioResponse> {

// @Autowired
// private UsuarioService service;

// @GetMapping
// public ResponseEntity<Collection<UsuarioResponse>> findAll(
// @RequestParam(name = "username", required = false) String username) {
// var usuario = Usuario.builder()
// .username(username)
// .build();

// ExampleMatcher matcher = ExampleMatcher.matchingAll()
// .withIgnoreNullValues()
// .withIgnoreCase();

// Example<Usuario> example = Example.of(usuario, matcher);

// var encontrados = service.findAll(example);
// var resposta = encontrados.stream()
// .map(service::toResponse)
// .toList();
// return ResponseEntity.ok(resposta);
// }

// @GetMapping("/{id}")
// @Override
// public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id) {
// var encontrado = service.findById(id);
// var resposta = service.toResponse(encontrado);
// return ResponseEntity.ok(resposta);
// }

// @Transactional
// @PostMapping
// @Override
// public ResponseEntity<UsuarioResponse> save(@RequestBody @Valid
// UsuarioRequest request) {
// var entity = service.toEntity(request);
// var saved = service.save(entity);
// var resposta = service.toResponse(saved);

// var uri = ServletUriComponentsBuilder
// .fromCurrentRequestUri()
// .path("/{id}")
// .buildAndExpand(saved.getId())
// .toUri();

// return ResponseEntity.created(uri).body(resposta);
// }
// }
