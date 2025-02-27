package com.sistema.moneyplus.repository;

import com.sistema.moneyplus.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    List<Conta> findByUsuarioId(Long usuarioId);
}
