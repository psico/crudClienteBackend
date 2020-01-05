package br.com.jg.crudcliente.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Email
 */
@Entity
@Table(name = "email")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Email {

    @Id
    @Column(name = "id_email")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_id_email_seq")
    @SequenceGenerator(name = "email_id_email_seq", sequenceName = "email_seq")
    private long idEmail;

    @NotNull
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "principal", nullable = false)
    private Boolean principal;

    //@TODO fazer relacionamento de FK futuramente
    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;

    public long getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(long idEmail) {
        this.idEmail = idEmail;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
