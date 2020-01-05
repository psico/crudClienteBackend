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
    @Column(name = "id_perfil")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_id_perfil_seq")
    @SequenceGenerator(name = "perfil_id_perfil_seq", sequenceName = "perfil_seq")
    private long idPerfil;

    @NotNull
    @Column(name = "descricao", nullable = false)
    private String descricao;

    public long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
