package br.com.jg.crudcliente.repository;

import br.com.jg.crudcliente.entity.LogOperacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogOperacoesRepository extends JpaRepository<LogOperacoes, Long> {
}
