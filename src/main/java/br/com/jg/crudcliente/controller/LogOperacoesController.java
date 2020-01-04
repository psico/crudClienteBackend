package br.com.jg.crudcliente.controller;

import br.com.jg.crudcliente.entity.LogOperacoes;
import br.com.jg.crudcliente.repository.LogOperacoesRepository;
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
public class LogOperacoesController {

    @Autowired
    private LogOperacoesRepository _logOperacoesRepository;

    @RequestMapping(value = "/logOperacoes", method = GET)
    public List<LogOperacoes> Get() {
        return _logOperacoesRepository.findAll();
    }

    @RequestMapping(value = "/logOperacoes/{id}", method = GET)
    public ResponseEntity<LogOperacoes> GetById(@PathVariable(value = "id") long id) {
        Optional<LogOperacoes> logOperacoes = _logOperacoesRepository.findById(id);
        if (logOperacoes.isPresent()) {
            return new ResponseEntity<LogOperacoes>(logOperacoes.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/logOperacoes", method = POST)
    public LogOperacoes Post(@Valid @RequestBody LogOperacoes logOperacoes) {
        return _logOperacoesRepository.save(logOperacoes);
    }
}
