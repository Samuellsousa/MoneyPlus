package com.sistema.moneyplus.models;

import jakarta.persistence.*;
import lombok.Data;  // Certifique-se de importar o @Data do Lombok
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data  // Lombok vai gerar automaticamente os métodos getters e setters
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private Date dataTransacao;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String categoria;

    // Construtor com os campos necessários
    public Transacao(Conta conta, BigDecimal valor, Date dataTransacao, String tipo, String categoria) {
        this.conta = conta;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    // Construtor padrão necessário para algumas operações ORM
    public Transacao() {
    }


    public Long getId() {
        return  id;
    }

    public Conta getConta() {
        return conta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }
}
