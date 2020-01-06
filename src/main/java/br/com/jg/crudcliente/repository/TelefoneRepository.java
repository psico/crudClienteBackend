package br.com.jg.crudcliente.repository;

import br.com.jg.crudcliente.entity.Endereco;
import br.com.jg.crudcliente.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    @Query("SELECT t FROM Telefone t WHERE t.idUsuario = ?1")
    List<Telefone> findByIdUsuario(long idUsuario);
}
