package br.com.jg.crudcliente.controller;

import br.com.jg.crudcliente.entity.Email;
import br.com.jg.crudcliente.repository.EmailRepository;
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
public class EmailController {

    @Autowired
    private EmailRepository _emailRepository;

    @RequestMapping(value = "/email", method = GET)
    public List<Email> Get() {
        return _emailRepository.findAll();
    }

    @RequestMapping(value = "/email/{id}", method = GET)
    public ResponseEntity<Email> GetById(@PathVariable(value = "id") long id) {
        Optional<Email> email = _emailRepository.findById(id);
        if (email.isPresent()) {
            return new ResponseEntity<Email>(email.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/email", method = POST)
    public Email Post(@Valid @RequestBody Email email) {
        return _emailRepository.save(email);
    }

    @RequestMapping(value = "/email/{id}", method = PUT)
    public ResponseEntity<Email> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Email newEmail) {
        Optional<Email> oldEmail = _emailRepository.findById(id);

        if (oldEmail.isPresent()) {
            Email email = oldEmail.get();
            email.setDescricao(newEmail.getDescricao());
            email.setPrincipal(newEmail.getPrincipal());
            _emailRepository.save(email);
            return new ResponseEntity<Email>(email, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/email/{id}", method = DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Email> email = _emailRepository.findById(id);

        if (email.isPresent()) {
            _emailRepository.delete(email.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
