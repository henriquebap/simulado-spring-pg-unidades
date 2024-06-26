package br.com.fiap.unidades.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record ChefeResponse(
                UnidadeResponse unidade,
                LocalDateTime inicio,
                LocalDateTime fim,
                Long id,
                UsuarioResponse usuario,
                Boolean substituto) {
}
