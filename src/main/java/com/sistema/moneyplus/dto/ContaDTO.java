package com.sistema.moneyplus.dto;

public class ContaDTO {
    private Long id;
    private Long usuarioId;
    private String nome;
    private String tipoConta;

    public ContaDTO() {}

    public ContaDTO(Long id, Long usuarioId, String nome, String tipoConta) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.tipoConta = tipoConta;
    }

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

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}
