package br.com.jg.crudcliente.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Perfil
 */
@Entity
@Table(name = "perfil")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
    @Column(name = "id_perfil")
    @SequenceGenerator(name = "sequenceGenerator")
    private long id_perfil;

    @NotNull
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public long getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(long id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
