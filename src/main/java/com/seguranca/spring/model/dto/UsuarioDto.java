package com.seguranca.spring.model.dto;

import com.seguranca.spring.model.UsuarioModel;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UsuarioDto {

    private Long id;
    private String nome;
    private String login;
    private String senha;


    public UsuarioDto(UsuarioModel usuarioModel){
        this.id = usuarioModel.getId();
        this.nome = usuarioModel.getNome();
        this.login = usuarioModel.getLogin();
        this.senha = usuarioModel.getSenha();
    }

    public static List<UsuarioDto> convert(List<UsuarioModel> usuarioModelList) {
        return usuarioModelList.stream().map(UsuarioDto::new).collect(Collectors.toList());
    }
}
