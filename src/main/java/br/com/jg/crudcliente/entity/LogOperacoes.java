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
    @Column(name = "id_log_operacoes")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_operacoes_id_log_operacoes_seq")
    @SequenceGenerator(name = "log_operacoes_id_log_operacoes_seq", sequenceName = "log_operacoes_seq")
    private long idLogOperacoes;

    @NotNull
    @Column(name = "tipo_operacao", nullable = false)
    private String tipoOperacao;

    @NotNull
    @Column(name = "data", nullable = false)
    private Date data;

    //@TODO fazer relacionamento de FK futuramente
    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;

//    public LogOperacoes(long idLogOperacoes) {
//        this.idLogOperacoes = idLogOperacoes;
//    }
//
//    public LogOperacoes(String tipoOperacao, long idUsuario) {
//        super();
//        this.tipoOperacao = tipoOperacao;
//        this.data = new Date();
//        this.idUsuario = idUsuario;
//    }

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

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
