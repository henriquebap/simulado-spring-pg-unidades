package br.com.fiap.unidades.dto.request;

import br.com.fiap.unidades.entity.Usuario;
import br.com.fiap.unidades.entity.Unidade;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChefeRequest extends AbstractRequest {

    private Boolean substituto;

    @NotNull(message = "Usuário é obrigatório")
    private Usuario usuario;

    @NotNull(message = "Unidade é obrigatória")
    private Unidade unidade;

    private LocalDateTime inicio;

    private LocalDateTime fim;
}
