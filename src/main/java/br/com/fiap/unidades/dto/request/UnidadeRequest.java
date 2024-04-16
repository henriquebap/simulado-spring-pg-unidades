package br.com.fiap.unidades.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UnidadeRequest extends AbstractRequest {

    private String nome;
    
    private String sigla;
    
    private String descricao;
    
    private AbstractRequest macro; // Representa a unidade macro
}
