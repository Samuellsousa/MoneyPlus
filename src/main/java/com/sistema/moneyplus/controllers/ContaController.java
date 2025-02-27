package com.sistema.moneyplus.controllers;

import com.sistema.moneyplus.dto.ContaDTO;
import com.sistema.moneyplus.models.Conta;
import com.sistema.moneyplus.models.Usuario;
import com.sistema.moneyplus.repository.ContaRepository;
import com.sistema.moneyplus.repository.UsuarioRepository; // Novo repositório para buscar o usuário
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContaController {

    private final ContaRepository contaRepository;
    private final UsuarioRepository usuarioRepository; // Repositório para o usuário

    // Injeção de dependências
    public ContaController(ContaRepository contaRepository, UsuarioRepository usuarioRepository) {
        this.contaRepository = contaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> listar() {
        return ResponseEntity.ok(contaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Conta> criar(@RequestBody ContaDTO contaDTO) {
        // Buscar o usuário pelo ID
        Usuario usuario = usuarioRepository.findById(contaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Criar a conta
        Conta conta = new Conta(usuario, contaDTO.getNome(), contaDTO.getTipoConta());
        return ResponseEntity.ok(contaRepository.save(conta));
    }
}
