package br.com.jg.crudcliente.controller;

import br.com.jg.crudcliente.entity.TipoTelefone;
import br.com.jg.crudcliente.repository.TipoTelefoneRepository;
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
public class TipoTelefoneController {

    @Autowired
    private TipoTelefoneRepository _tipoTelefoneRepository;

    @RequestMapping(value = "/tipoTelefone", method = GET)
    public List<TipoTelefone> Get() {
        return _tipoTelefoneRepository.findAll();
    }

    @RequestMapping(value = "/tipoTelefone/{id}", method = GET)
    public ResponseEntity<TipoTelefone> GetById(@PathVariable(value = "id") long id) {
        Optional<TipoTelefone> tipoTelefone = _tipoTelefoneRepository.findById(id);
        if (tipoTelefone.isPresent()) {
            return new ResponseEntity<TipoTelefone>(tipoTelefone.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/tipoTelefone", method = POST)
    public TipoTelefone Post(@Valid @RequestBody TipoTelefone tipoTelefone) {
        return _tipoTelefoneRepository.save(tipoTelefone);
    }

    @RequestMapping(value = "/tipoTelefone/{id}", method = PUT)
    public ResponseEntity<TipoTelefone> Put(@PathVariable(value = "id") long id, @Valid @RequestBody TipoTelefone newTipoTelefone) {
        Optional<TipoTelefone> oldTipoTelefone = _tipoTelefoneRepository.findById(id);

        if (oldTipoTelefone.isPresent()) {
            TipoTelefone tipoTelefone = oldTipoTelefone.get();
            tipoTelefone.setDescricao(newTipoTelefone.getDescricao());
            _tipoTelefoneRepository.save(tipoTelefone);
            return new ResponseEntity<TipoTelefone>(tipoTelefone, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/tipoTelefone/{id}", method = DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<TipoTelefone> tipoTelefone = _tipoTelefoneRepository.findById(id);

        if (tipoTelefone.isPresent()) {
            _tipoTelefoneRepository.delete(tipoTelefone.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
