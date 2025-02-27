package com.sistema.moneyplus.repository;

import com.sistema.moneyplus.models.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    List<Cartao> findByUsuarioId(Long usuarioId);
}
