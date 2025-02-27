package com.sistema.moneyplus.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parcelas")
public class Parcelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cartao_id", nullable = false)
    private Cartao cartao;

    @Column(nullable = false)
    private BigDecimal valor; // Mudança de Double para BigDecimal para valores monetários

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataVencimento;

    @Column(nullable = false)
    private Integer numeroParcela;

    @Column(nullable = false)
    private Integer totalParcelas;

    public Parcelas(Cartao cartao, BigDecimal valor, Date dataVencimento, Integer numeroParcela, Integer totalParcelas) {
    }

    public Long getId() {
        return id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Integer getNumeroParcela() {
    return numeroParcela;
    }


    public Integer getTotalParcelas() {
        return totalParcelas;
    }

}
