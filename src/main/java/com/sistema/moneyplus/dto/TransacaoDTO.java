package com.sistema.moneyplus.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoDTO {
    private Long id;
    private Long contaId;
    private BigDecimal valor;
    private Date dataTransacao;
    private String tipo;
    private String categoria;

    // Construtor
    public TransacaoDTO(Long id, Long contaId, BigDecimal valor, Date dataTransacao, String tipo, String categoria) {
        this.id = id;
        this.contaId = contaId;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
