package br.com.fiap.unidades.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CHEFE")
    @SequenceGenerator(name = "SQ_CHEFE", sequenceName = "SQ_CHEFE", allocationSize = 1)
    @Column(name = "ID_CHEFE")
    private Long id;

    @Column(name = "SUBISTITUTO_CHEFE")
    private Boolean substituto;

    @Column(name = "USER_CHEFE")
    private Usuario usuario;

    @Column(name = "UNI_CHEFE")
    private Unidade unidade;

    @Column(name = "DT_INICIO")
    private LocalDateTime inicio;

    @Column(name = "DT_FIM")
    private LocalDateTime fim;

}
