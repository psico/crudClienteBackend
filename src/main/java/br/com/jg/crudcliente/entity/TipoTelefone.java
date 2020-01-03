package br.com.jg.crudcliente.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * TipoTelefone
 */
@Entity
@Table(name = "tipo_telefone")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TipoTelefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
    @Column(name = "tipo_telefone")
    @SequenceGenerator(name = "sequenceGenerator")
    private long tipoTelefone;

    @NotNull
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public long getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(long tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
