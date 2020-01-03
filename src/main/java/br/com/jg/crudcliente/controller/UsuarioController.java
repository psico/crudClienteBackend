package br.com.jg.crudcliente.controller;

import br.com.jg.crudcliente.entity.Usuario;
import br.com.jg.crudcliente.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository _usuarioRepository;

    @RequestMapping(value = "/usuario", method = GET)
    public List<Usuario> Get() {
        return _usuarioRepository.findAll();
    }
}
