package br.com.jg.crudcliente.repository;

import br.com.jg.crudcliente.entity.LogOperacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogOperacoesRepository extends JpaRepository<LogOperacoes, Long> {
    @Query("SELECT l FROM LogOperacoes l WHERE l.idUsuario = ?1")
    List<LogOperacoes> findByIdUsuario(long idUsuario);
}
