package br.com.fiap.unidades.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(

    @Size(min = 3, max = 255)
    @NotNull(message = "Username não pode ser vazio")
    String username,

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}")
    @NotNull(message = "Senha é obrigatório!")
    String password,

    @Valid // Garante que a validação seja aplicada ao objeto PessoaRequest
    @NotNull(message = "Pessoa é obrigatória")
    PessoaRequest pessoa

) {
}
