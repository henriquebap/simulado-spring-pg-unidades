package br.com.fiap.unidades.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.fiap.unidades.dto.request.ChefeRequest;
import br.com.fiap.unidades.dto.response.ChefeResponse;
import br.com.fiap.unidades.entity.Chefe;
import br.com.fiap.unidades.repository.ChefeRepository;

import java.util.List;

@Service
public class ChefeService implements ServiceDTO<Chefe, ChefeRequest, ChefeResponse> {

    @Autowired
    private ChefeRepository repo;

    @Override
    public Chefe toEntity(ChefeRequest r) {
        // Converter ChefeRequest para a entidade Chefe.
        return Chefe.builder()
                .substituto(r.getSubstituto())
                .usuario(r.getUsuario())
                .unidade(r.getUnidade())
                .inicio(r.getInicio())
                .fim(r.getFim())
                .build();
    }

    @Override
    public ChefeResponse toResponse(Chefe e) {
        // Converter a entidade Chefe para ChefeResponse.
        return ChefeResponse.builder()
                .id(e.getId())
                .substituto(e.getSubstituto())
                // .usuario(e.getUsuario())
                // .unidade(e.getUnidade())
                .inicio(e.getInicio())
                .fim(e.getFim())
                .build();
    }

    @Override
    public List<Chefe> findAll() {
        return repo.findAll();
    }

    @Override
    public List<Chefe> findAll(Example<Chefe> example) {
        return repo.findAll(example);
    }

    @Override
    public Chefe findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Chefe save(Chefe e) {
        return repo.save(e);
    }
}
