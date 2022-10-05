package com.seguranca.spring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column @NotNull
    private String nome;
    @Column @NotNull
    private String idade;
    @Column @NotNull
    private String telefone;
    @Column @NotNull
    private String login;
    @Column @NotNull
    private String senha;
}
