package br.com.jg.crudcliente.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * LogOperacoes
 */
@Entity
@Table(name = "log_operacoes")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class LogOperacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
    @Column(name = "id_log_operacoes")
    @SequenceGenerator(name = "sequenceGenerator")
    private long idLogOperacoes;

    @NotNull
    @Column(name = "tipo_operacao", nullable = false)
    private String tipoOperacao;

    @NotNull
    @Column(name = "data", nullable = false)
    private Date data;

//    private long id_usuario;


    public long getIdLogOperacoes() {
        return idLogOperacoes;
    }

    public void setIdLogOperacoes(long idLogOperacoes) {
        this.idLogOperacoes = idLogOperacoes;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
