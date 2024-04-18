package br.com.fiap.unidades.service;

import br.com.fiap.unidades.dto.request.UnidadeRequest;
import br.com.fiap.unidades.dto.response.UnidadeResponse;
import br.com.fiap.unidades.entity.Unidade;
import br.com.fiap.unidades.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository repo;

    public Unidade toEntity(UnidadeRequest r) {
        Unidade macro = null;
        if (r.getMacro() != null && r.getMacro().getId() != null) {
            macro = repo.findById(r.getMacro().getId()).orElse(null);
        }

        return Unidade.builder()
                .nome(r.getNome())
                .sigla(r.getSigla())
                .descricao(r.getDescricao())
                .macro(macro)
                .build();
    }

    public UnidadeResponse toResponse(Unidade u) {
        UnidadeResponse macroResponse = null;
        if (u.getMacro() != null) {
            macroResponse = toResponse(u.getMacro());
        }

        return UnidadeResponse.builder()
                .id(u.getId())
                .nome(u.getNome())
                .sigla(u.getSigla())
                .descricao(u.getDescricao())
                .macro(macroResponse)
                .build();
    }

    public List<Unidade> findAll() {
        return repo.findAll();
    }

    public List<Unidade> findAll(Example<Unidade> example) {
        return repo.findAll(example);
    }

    public Unidade findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Unidade save(Unidade u) {
        return repo.save(u);
    }
}
