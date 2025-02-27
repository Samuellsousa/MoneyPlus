package com.sistema.moneyplus.controllers;

import com.sistema.moneyplus.models.Transacao;
import com.sistema.moneyplus.repository.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoRepository transacaoRepository;

    // Injeção de dependência do repositório de Transação
    public TransacaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    // Endpoint para listar todas as transações
    @GetMapping
    public ResponseEntity<List<Transacao>> listar() {
        List<Transacao> transacoes = transacaoRepository.findAll();
        if (transacoes.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 caso não haja transações
        }
        return ResponseEntity.ok(transacoes);
    }

    // Endpoint para criar uma nova transação
    @PostMapping
    public ResponseEntity<Transacao> criar(@RequestBody  Transacao transacao) {
        // Salvando a nova transação no banco de dados
        Transacao novaTransacao = transacaoRepository.save(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao); // Retorna a transação criada com status 201
    }
}
