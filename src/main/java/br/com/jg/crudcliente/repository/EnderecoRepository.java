package br.com.jg.crudcliente.repository;

import br.com.jg.crudcliente.entity.Email;
import br.com.jg.crudcliente.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("SELECT e FROM Endereco e WHERE e.idUsuario = ?1")
    List<Endereco> findByIdUsuario(long idUsuario);
}
