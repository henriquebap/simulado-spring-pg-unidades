// package br.com.fiap.unidades.service;

// import br.com.fiap.unidades.dto.request.UsuarioRequest;
// import br.com.fiap.unidades.dto.response.UsuarioResponse;
// import br.com.fiap.unidades.entity.Usuario;
// import br.com.fiap.unidades.repository.UsuarioRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Example;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class UsuarioService implements ServiceDTO<Usuario, UsuarioRequest,
// UsuarioResponse> {

// @Autowired
// private UsuarioRepository repo;

// // @Override
// // public Usuario toEntity(UsuarioRequest r) {

// // return Usuario.builder()
// // .username(r.username())
// // .password(r.password())
// // .pessoa(r.pessoa())
// // .build();
// // }

// // @Override
// // public UsuarioResponse toResponse(Usuario u) {
// // // Converter Usuario em UsuarioResponse
// // return UsuarioResponse.builder()
// // .id(u.getId())
// // .username(u.getUsername())
// // .pessoa(u.getPessoa().toResponse());
// // }

// @Override
// public List<Usuario> findAll() {
// // Retornar todos os usuarios
// return repo.findAll();
// }

// @Override
// public List<Usuario> findAll(Example<Usuario> example) {
// // Retornar todos os usuarios com base em um exemplo de pesquisa
// return repo.findAll(example);
// }

// @Override
// public Usuario findById(Long id) {
// // Encontrar um usuario pelo ID
// return repo.findById(id).orElse(null);
// }

// @Override
// public Usuario save(Usuario usuario) {
// // Salvar um usuario
// return repo.save(usuario);
// }
// }
