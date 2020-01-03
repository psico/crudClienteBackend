package br.com.jg.crudcliente.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Telefone
 */
@Entity
@Table(name = "telefone")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
    @Column(name = "id_telefone")
    @SequenceGenerator(name = "sequenceGenerator")
    private long idTelefone;

    @NotNull
    @Column(name = "ddi", nullable = false)
    private String ddi;

    @NotNull
    @Column(name = "ddd", nullable = false)
    private String ddd;

    @NotNull
    @Column(name = "telefone", nullable = false)
    private String telefone;

    //@TODO fazer relacionamento de FK futuramente
    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;

    //@TODO fazer relacionamento de FK futuramente
    @NotNull
    @Column(name = "id_tipo_telefone", nullable = false)
    private long idTipoTelefone;

    public long getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdTipoTelefone() {
        return idTipoTelefone;
    }

    public void setIdTipoTelefone(long idTipoTelefone) {
        this.idTipoTelefone = idTipoTelefone;
    }
}
