package com.sistema.moneyplus.dto;

import java.math.BigDecimal;

public class CartaoDTO {
    private Long id;
    private Long usuarioId;
    private String nome;
    private BigDecimal limite;  // Alterei para BigDecimal para consistência
    private Integer vencimento;

    // Construtor com BigDecimal no limite
    public CartaoDTO(Long id, Long usuarioId, String nome, BigDecimal limite, Integer vencimento) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.limite = limite;
        this.vencimento = vencimento;
    }

    // Construtor com Double no limite
    public CartaoDTO(Long id, Long usuarioId, String nome, Double limite, Integer vencimento) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.limite = BigDecimal.valueOf(limite);  // Converte o Double para BigDecimal
        this.vencimento = vencimento;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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
