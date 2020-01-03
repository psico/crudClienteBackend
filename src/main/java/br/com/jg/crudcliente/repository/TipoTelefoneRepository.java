package br.com.jg.crudcliente.repository;

import br.com.jg.crudcliente.entity.TipoTelefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTelefoneRepository extends JpaRepository<TipoTelefone, Long> {
}
