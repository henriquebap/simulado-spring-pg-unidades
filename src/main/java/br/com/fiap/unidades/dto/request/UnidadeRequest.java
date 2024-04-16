package br.com.fiap.unidades.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UnidadeRequest extends AbstractRequest {

    @NotEmpty(message = "Nome não pode ser vazio")
    private String nome;

    @NotEmpty(message = "Sigla não pode ser vazia")
    private String sigla;
    
    private String descricao;
    
    private AbstractRequest macro; // Representa a unidade macro
}
