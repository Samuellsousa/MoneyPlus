package com.sistema.moneyplus.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ParcelasDTO {
    private Long id;
    private Long cartaoId;
    private BigDecimal valor;  // Alterado para BigDecimal
    private Date dataVencimento;
    private Integer numeroParcela;
    private Integer totalParcelas;

    // Construtor padrão
    public ParcelasDTO() {}

    // Construtor com parâmetros
    public ParcelasDTO(Long id, Long cartaoId, BigDecimal valor, Date dataVencimento, Integer numeroParcela, Integer totalParcelas) {
        this.id = id;
        this.cartaoId = cartaoId;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.numeroParcela = numeroParcela;
        this.totalParcelas = totalParcelas;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(Long cartaoId) {
        this.cartaoId = cartaoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public Integer getTotalParcelas() {
        return totalParcelas;
    }

    public void setTotalParcelas(Integer totalParcelas) {
        this.totalParcelas = totalParcelas;
    }
}
