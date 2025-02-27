package com.sistema.moneyplus.services;

import com.sistema.moneyplus.dto.ParcelasDTO;
import com.sistema.moneyplus.models.Cartao;
import com.sistema.moneyplus.models.Parcelas;
import com.sistema.moneyplus.repository.CartaoRepository;
import com.sistema.moneyplus.repository.ParcelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParcelasService {

    @Autowired
    private ParcelasRepository parcelasRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    public List<ParcelasDTO> listarParcelas(Long cartaoId) {
        List<Parcelas> parcelas = parcelasRepository.findByCartaoId(cartaoId);
        return parcelas.stream()
                .map(p -> new ParcelasDTO(p.getId(), p.getCartao().getId(), p.getValor(), p.getDataVencimento(), p.getNumeroParcela(), p.getTotalParcelas()))
                .collect(Collectors.toList());
    }

    public ParcelasDTO criarParcela(ParcelasDTO parcelasDTO) {
        Optional<Cartao> cartao = cartaoRepository.findById(parcelasDTO.getCartaoId());
        if (cartao.isPresent()) {
            Parcelas parcela = new Parcelas(cartao.get(), parcelasDTO.getValor(), parcelasDTO.getDataVencimento(), parcelasDTO.getNumeroParcela(), parcelasDTO.getTotalParcelas());
            Parcelas parcelaSalva = parcelasRepository.save(parcela);
            return new ParcelasDTO(parcelaSalva.getId(), parcelaSalva.getCartao().getId(), parcelaSalva.getValor(), parcelaSalva.getDataVencimento(), parcelaSalva.getNumeroParcela(), parcelaSalva.getTotalParcelas());
        }
        return null;
    }

    public boolean deletarParcela(Long id) {
        Optional<Parcelas> parcelaOptional = parcelasRepository.findById(id);
        if (parcelaOptional.isPresent()) {
            parcelasRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
