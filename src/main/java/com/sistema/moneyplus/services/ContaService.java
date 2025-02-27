package com.sistema.moneyplus.services;

import com.sistema.moneyplus.dto.ContaDTO;
import com.sistema.moneyplus.models.Conta;
import com.sistema.moneyplus.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    // Listar todas as contas de um usuário
    public List<ContaDTO> listarContas(Long usuarioId) {
        List<Conta> contas = contaRepository.findByUsuarioId(usuarioId);
        return contas.stream()
                .map(conta -> new ContaDTO(conta.getId(),
                        conta.getUsuario() != null ? conta.getUsuario().getId() : null,
                        conta.getNome(),
                        conta.getTipoConta()))
                .toList();
    }

    // Criar uma nova conta
    public ContaDTO criarConta(ContaDTO contaDTO) {
        Conta conta = new Conta(contaDTO.getUsuarioId(), contaDTO.getNome(), contaDTO.getTipoConta());
        Conta contaSalva = contaRepository.save(conta);
        return new ContaDTO(contaSalva.getId(),
                contaSalva.getUsuario() != null ? contaSalva.getUsuario().getId() : null,
                contaSalva.getNome(),
                contaSalva.getTipoConta());
    }

    // Atualizar uma conta
    public ContaDTO atualizarConta(Long id, ContaDTO contaDTO) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isPresent()) {
            Conta conta = contaOptional.get();
            conta.setNome(contaDTO.getNome());
            conta.setTipoConta(contaDTO.getTipoConta());
            Conta contaAtualizada = contaRepository.save(conta);
            return new ContaDTO(contaAtualizada.getId(),
                    contaAtualizada.getUsuario() != null ? contaAtualizada.getUsuario().getId() : null,
                    contaAtualizada.getNome(),
                    contaAtualizada.getTipoConta());
        }
        return null;
    }

    // Deletar uma conta
    public boolean deletarConta(Long id) {
        Optional<Conta> contaOptional = contaRepository.findById(id);
        if (contaOptional.isPresent()) {
            contaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
