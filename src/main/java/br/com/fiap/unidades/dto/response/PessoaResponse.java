package br.com.fiap.unidades.dto.response;

import java.time.LocalDate;

import br.com.fiap.unidades.entity.Tipo;
import lombok.Builder;

@Builder
public record PessoaResponse(

    Long id,
    String nome,
    String sobrenome,
    String email,
    LocalDate nascimento,
    Tipo tipo


) {
}
