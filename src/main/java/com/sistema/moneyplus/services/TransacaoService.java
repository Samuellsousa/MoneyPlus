package com.sistema.moneyplus.services;

import com.sistema.moneyplus.dto.TransacaoDTO;
import com.sistema.moneyplus.models.Conta;
import com.sistema.moneyplus.models.Transacao;
import com.sistema.moneyplus.repository.TransacaoRepository;
import com.sistema.moneyplus.repository.ContaRepository; // Assumindo que você tem um repositório para a Conta
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaRepository contaRepository; // Repositório para acessar Conta

    public List<TransacaoDTO> listarTransacoes(Long contaId) {
        List<Transacao> transacoes = transacaoRepository.findByContaId(contaId);
        return transacoes.stream()
                .map(transacao -> new TransacaoDTO(
                        transacao.getId(),
                        transacao.getConta().getId(),  // Conta associada
                        transacao.getValor(),
                        transacao.getDataTransacao(),
                        transacao.getTipo(),
                        transacao.getCategoria()))
                .collect(Collectors.toList());
    }

    public TransacaoDTO criarTransacao(TransacaoDTO transacaoDTO) {
        // Verificar se a Conta existe
        Optional<Conta> contaOptional = contaRepository.findById(transacaoDTO.getContaId());
        if (contaOptional.isEmpty()) {
            throw new IllegalArgumentException("Conta não encontrada");
        }

        // Criar nova transação
        Conta conta = contaOptional.get();
        Transacao transacao = new Transacao(
                conta,
                transacaoDTO.getValor(),
                transacaoDTO.getDataTransacao(),
                transacaoDTO.getTipo(),
                transacaoDTO.getCategoria()
        );

        // Salvar a transação
        Transacao transacaoSalva = transacaoRepository.save(transacao);
        return new TransacaoDTO(
                transacaoSalva.getId(),
                transacaoSalva.getConta().getId(),
                transacaoSalva.getValor(),
                transacaoSalva.getDataTransacao(),
                transacaoSalva.getTipo(),
                transacaoSalva.getCategoria());
    }

    public boolean deletarTransacao(Long id) {
        Optional<Transacao> transacaoOptional = transacaoRepository.findById(id);
        if (transacaoOptional.isPresent()) {
            transacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
