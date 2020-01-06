package br.com.jg.crudcliente.controller;

import br.com.jg.crudcliente.entity.LogOperacoes;
import br.com.jg.crudcliente.entity.Telefone;
import br.com.jg.crudcliente.entity.Usuario;
import br.com.jg.crudcliente.repository.LogOperacoesRepository;
import br.com.jg.crudcliente.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
public class TelefoneController {

    @Autowired
    private TelefoneRepository _telefoneRepository;
    @Autowired
    private LogOperacoesRepository _logOperacoesRepository;

    @RequestMapping(value = "/telefone", method = GET)
    public List<Telefone> Get() {
        return _telefoneRepository.findAll();
    }

    @RequestMapping(value = "/telefone/{id}", method = GET)
    public ResponseEntity<Telefone> GetById(@PathVariable(value = "id") long id) {
        Optional<Telefone> telefone = _telefoneRepository.findById(id);
        if (telefone.isPresent()) {
            return new ResponseEntity<Telefone>(telefone.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/telefone", method = POST)
    public Telefone Post(@Valid @RequestBody Telefone telefone) {
        Telefone returnTelefone = _telefoneRepository.save(telefone);
        LogOperacoes logOperacoes = new LogOperacoes();
        logOperacoes.setTipoOperacao("Insert Telefone");
        logOperacoes.setData(new Date());
        logOperacoes.setIdUsuario(telefone.getIdUsuario());
        _logOperacoesRepository.save(logOperacoes);
        return returnTelefone;
    }

    @RequestMapping(value = "/telefone/{id}", method = PUT)
    public ResponseEntity<Telefone> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Telefone newTelefone) {
        Optional<Telefone> oldTelefone = _telefoneRepository.findById(id);

        if (oldTelefone.isPresent()) {
            Telefone telefone = oldTelefone.get();
            telefone.setDdi(newTelefone.getDdi());
            telefone.setDdd(newTelefone.getDdd());
            telefone.setTelefone(newTelefone.getTelefone());
            telefone.setIdUsuario(newTelefone.getIdUsuario());
            telefone.setIdTipoTelefone(newTelefone.getIdTipoTelefone());
            _telefoneRepository.save(telefone);
            return new ResponseEntity<Telefone>(telefone, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/telefone/{id}", method = DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Telefone> telefone = _telefoneRepository.findById(id);

        if (telefone.isPresent()) {
            LogOperacoes logOperacoes = new LogOperacoes();
            logOperacoes.setTipoOperacao("Delete Telefone");
            logOperacoes.setData(new Date());
            logOperacoes.setIdUsuario(telefone.get().getIdUsuario());
            _logOperacoesRepository.save(logOperacoes);

            _telefoneRepository.delete(telefone.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
