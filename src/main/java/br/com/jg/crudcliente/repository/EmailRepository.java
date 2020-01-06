package br.com.jg.crudcliente.repository;

import br.com.jg.crudcliente.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
    @Query("SELECT e FROM Email e WHERE e.idUsuario = ?1")
    List<Email> findByIdUsuario(long idUsuario);
}
