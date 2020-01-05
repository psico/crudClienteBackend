package br.com.jg.crudcliente.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import br.com.jg.crudcliente.entity.Endereco;
import br.com.jg.crudcliente.repository.EnderecoRepository;

@CrossOrigin
@RestController
public class EnderecoController {

    @Autowired
    private EnderecoRepository _enderecoRepository;

    @RequestMapping(value = "/endereco", method = GET)
    public List<Endereco> Get() {
        return _enderecoRepository.findAll();
    }

    @RequestMapping(value = "/endereco/{id}", method = GET)
    public ResponseEntity<Endereco> GetById(@PathVariable(value = "id") long id) {
        Optional<Endereco> endereco = _enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            return new ResponseEntity<Endereco>(endereco.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/endereco", method = POST)
    public Endereco Post(@Valid @RequestBody Endereco endereco) {
        return _enderecoRepository.save(endereco);
    }

    @RequestMapping(value = "/endereco/{id}", method = PUT)
    public ResponseEntity<Endereco> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Endereco newEndereco) {
        Optional<Endereco> oldEndereco = _enderecoRepository.findById(id);

        if (oldEndereco.isPresent()) {
            Endereco endereco = oldEndereco.get();
            endereco.setLogradouro(newEndereco.getLogradouro());
            endereco.setBairro(newEndereco.getBairro());
            endereco.setCidade(newEndereco.getCidade());
            endereco.setUf(newEndereco.getUf());
            endereco.setComplemento(newEndereco.getComplemento());
            endereco.setIdUsuario(newEndereco.getIdUsuario());
            _enderecoRepository.save(endereco);
            return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/endereco/{id}", method = DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Endereco> endereco = _enderecoRepository.findById(id);

        if (endereco.isPresent()) {
            _enderecoRepository.delete(endereco.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
