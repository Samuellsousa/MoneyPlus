package com.sistema.moneyplus.models;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "cartoes")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipoCartao; // Crédito ou Débito

    @Column(nullable = false)
    private BigDecimal limite;

    @Column(nullable = false)
    private LocalDate vencimentoFatura;

    @Column(nullable = false)
    private Integer vencimento;

    // Construtor
    public Cartao(Usuario usuario, String nome, BigDecimal limite, Integer vencimento) {
        this.usuario = usuario;
        this.nome = nome;
        this.limite = limite;
        this.vencimento = vencimento;
    }

    // Métodos getter e setter
    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public Integer getVencimento() {
        return vencimento;
    }

    public void setVencimento(Integer vencimento) {
        this.vencimento = vencimento;
    }
}
