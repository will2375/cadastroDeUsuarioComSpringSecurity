package com.seguranca.spring.controller;

import com.seguranca.spring.Service.UsuarioService;
import com.seguranca.spring.model.UsuarioModel;
import com.seguranca.spring.model.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> mostrarUsuarios(){return ResponseEntity.ok(usuarioService.listaDeUsuario());}

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> buscarId(@PathVariable Long id) {return  usuarioService.buscarPorId(id);}

    @PostMapping
    public ResponseEntity<UsuarioModel>cadastrar(@RequestBody @Valid UsuarioModel usuarioModel) {
        UsuarioModel salvar = usuarioService.cadastrar(usuarioModel);
        return new ResponseEntity<>(salvar, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuarioModel> alterar(@RequestBody UsuarioModel usuarioModel){
        UsuarioModel salvar = usuarioService.cadastrar(usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(salvar);
    }
}
