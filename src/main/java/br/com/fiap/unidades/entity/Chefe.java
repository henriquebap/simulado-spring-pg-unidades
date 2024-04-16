package br.com.fiap.unidades.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_SIMULADO_CHEFE", uniqueConstraints = {
    @UniqueConstraint(name = "UK_USUARIO", columnNames = "USUARIO_CHEFE"),
    @UniqueConstraint(name = "UK_UNIDADE", columnNames = "UNIDADE_CHEFE"),
    @UniqueConstraint(name = "UK_DATA_FIM", columnNames = "DATA_FIM_CHEFE")
})

public class Chefe {

    private Long id;

    private Boolean substituto;

    private Usuario usuario;

    private Unidade unidade;

    private LocalDateTime inicio;

    private LocalDateTime fim;

}
