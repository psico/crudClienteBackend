package br.com.jg.crudcliente.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Usuario
 */
@Entity
@Table(name = "usuario")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
    @Column(name = "id_usuario")
    @SequenceGenerator(name = "sequenceGenerator")
    private long idUsuario;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "cpf", precision = 11, nullable = false)
    private String cpf;

    @NotNull
    @Column(name = "senha", nullable = false)
    private String senha;

//    private long id_perfil;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
