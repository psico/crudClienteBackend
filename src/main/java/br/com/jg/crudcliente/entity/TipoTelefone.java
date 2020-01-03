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
    @Column(name = "id_tipo_telefone")
    @SequenceGenerator(name = "sequenceGenerator")
    private long idTipoTelefone;

    @NotNull
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public long getIdTipoTelefone() {
        return idTipoTelefone;
    }

    public void setIdTipoTelefone(long idTipoTelefone) {
        this.idTipoTelefone = idTipoTelefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
