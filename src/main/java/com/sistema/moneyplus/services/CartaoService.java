package com.sistema.moneyplus.services;

import com.sistema.moneyplus.dto.CartaoDTO;
import com.sistema.moneyplus.models.Cartao;
import com.sistema.moneyplus.models.Usuario;
import com.sistema.moneyplus.repository.CartaoRepository;
import com.sistema.moneyplus.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar cartões por usuário
    public List<CartaoDTO> listarCartoes(Long usuarioId) {
        List<Cartao> cartoes = cartaoRepository.findByUsuarioId(usuarioId);
        return cartoes.stream()
                .map(cartao -> new CartaoDTO(cartao.getId(), (Long) cartao.getUsuario().getId(), cartao.getNome(), cartao.getLimite(), cartao.getVencimento()))
                .toList();
    }

    // Criar um novo cartão
    public CartaoDTO criarCartao(CartaoDTO cartaoDTO) {
        Usuario usuario = usuarioRepository.findById(cartaoDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Cartao cartao = new Cartao(usuario, cartaoDTO.getNome(), cartaoDTO.getLimite(), cartaoDTO.getVencimento());
        Cartao cartaoSalvo = cartaoRepository.save(cartao);

        return new CartaoDTO(cartaoSalvo.getId(), (Long) cartaoSalvo.getUsuario().getId(), cartaoSalvo.getNome(), cartaoSalvo.getLimite(), cartaoSalvo.getVencimento());
    }

    // Atualizar um cartão existente
    public CartaoDTO atualizarCartao(Long id, CartaoDTO cartaoDTO) {
        Cartao cartao = cartaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        cartao.setNome(cartaoDTO.getNome());
        cartao.setLimite(cartaoDTO.getLimite());
        cartao.setVencimento(cartaoDTO.getVencimento());
        Cartao cartaoAtualizado = cartaoRepository.save(cartao);

        return new CartaoDTO(cartaoAtualizado.getId(), (Long) cartaoAtualizado.getUsuario().getId(), cartaoAtualizado.getNome(), cartaoAtualizado.getLimite(), cartaoAtualizado.getVencimento());
    }

    // Deletar um cartão
    public boolean deletarCartao(Long id) {
        if (cartaoRepository.existsById(id)) {
            cartaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
