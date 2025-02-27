package com.sistema.moneyplus.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipoConta;

    // Construtor sem argumentos (necessário para o Hibernate)
    public Conta() {
    }

    // Construtor com parâmetros (para criação manual de instâncias)
    public Conta(Usuario usuario, String nome, String tipoConta) {
        this.usuario = usuario;
        this.nome = nome;
        this.tipoConta = tipoConta;
    }

    // Getters e Setters (gerados pelo Lombok)


public Conta(Long usuarioId, String nome, String tipoConta) {
    }

    // Métodos getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {  // Alterado para retornar Usuario
        return usuario;
    }

    public void setUsuario(Usuario usuario) {  // Alterado para aceitar um objeto Usuario
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}
