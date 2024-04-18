package br.com.fiap.unidades.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_SIMULADO_UNIDADE", uniqueConstraints = {
        @UniqueConstraint(name = "UK_SIGLA", columnNames = "SIGLA_UNIDADE")
// Nao pode ter a mesma sigla na mesma unidade, mas pode ter varias siglas
// iguais se for em outras unidades, como fazer isso?
})
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_UNIDADE")
    @SequenceGenerator(name = "SQ_UNIDADE", sequenceName = "SQ_UNIDADE", allocationSize = 1)
    @Column(name = "ID_UNIDADE")
    private Long id;

    @Column(name = "NM_UNIDADE")
    private String nome;

    @Column(name = "SIGLA_UNIDADE")
    private String sigla;

    @Column(name = "DESC_UNIDADE")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "MACRO_UNIDADE_ID")
    private Unidade macro;

}
