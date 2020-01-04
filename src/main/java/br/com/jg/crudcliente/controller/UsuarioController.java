package br.com.jg.crudcliente.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import br.com.jg.crudcliente.entity.Usuario;
import br.com.jg.crudcliente.repository.UsuarioRepository;

@CrossOrigin
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository _usuarioRepository;

    @RequestMapping(value = "/usuario", method = GET)
    public List<Usuario> Get() {
        return _usuarioRepository.findAll();
    }

    @RequestMapping(value = "/usuario/{id}", method = GET)
    public ResponseEntity<Usuario> GetById(@PathVariable(value = "id") long id) {
        Optional<Usuario> usuario = _usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/usuario", method = POST)
    public Usuario Post(@Valid @RequestBody Usuario usuario) {
        return _usuarioRepository.save(usuario);
    }

    @RequestMapping(value = "/usuario/{id}", method = PUT)
    public ResponseEntity<Usuario> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Usuario newUsuario) {
        Optional<Usuario> oldUsuario = _usuarioRepository.findById(id);

        if (oldUsuario.isPresent()) {
            Usuario usuario = oldUsuario.get();
            usuario.setNome(newUsuario.getNome());
            _usuarioRepository.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/usuario/{id}", method = DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Usuario> usuario = _usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            _usuarioRepository.delete(usuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
