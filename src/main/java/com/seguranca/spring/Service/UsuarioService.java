package com.seguranca.spring.Service;

import com.seguranca.spring.model.UsuarioModel;
import com.seguranca.spring.model.dto.UsuarioDto;
import com.seguranca.spring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public List<UsuarioDto> listaDeUsuario(){ List<UsuarioModel>usuarios = usuarioRepository.findAll(); return UsuarioDto.convert(usuarios);}

    public Optional<UsuarioModel>buscarPorId(Long id){return usuarioRepository.findById(id);}

    public UsuarioModel cadastrar(UsuarioModel usuarioModel){
        usuarioModel.setSenha(passwordEncoder().encode(usuarioModel.getSenha()));
        return usuarioRepository.save(usuarioModel);
    }
}
