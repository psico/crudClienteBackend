package br.com.jg.crudcliente.controller;

import br.com.jg.crudcliente.entity.Perfil;
import br.com.jg.crudcliente.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
public class PerfilController {

    @Autowired
    private PerfilRepository _perfilRepository;

    @RequestMapping(value = "/perfil", method = GET)
    public List<Perfil> Get() {
        return _perfilRepository.findAll();
    }

    @RequestMapping(value = "/perfil/{id}", method = GET)
    public ResponseEntity<Perfil> GetById(@PathVariable(value = "id") long id) {
        Optional<Perfil> perfil = _perfilRepository.findById(id);
        if (perfil.isPresent()) {
            return new ResponseEntity<Perfil>(perfil.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/perfil", method = POST)
    public Perfil Post(@Valid @RequestBody Perfil perfil) {
        return _perfilRepository.save(perfil);
    }

    @RequestMapping(value = "/perfil/{id}", method = PUT)
    public ResponseEntity<Perfil> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Perfil newPerfil) {
        Optional<Perfil> oldPerfil = _perfilRepository.findById(id);

        if (oldPerfil.isPresent()) {
            Perfil perfil = oldPerfil.get();
            perfil.setDescricao(newPerfil.getDescricao());
            _perfilRepository.save(perfil);
            return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/perfil/{id}", method = DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Perfil> perfil = _perfilRepository.findById(id);

        if (perfil.isPresent()) {
            _perfilRepository.delete(perfil.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
