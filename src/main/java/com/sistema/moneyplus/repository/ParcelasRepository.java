package com.sistema.moneyplus.repository;

import com.sistema.moneyplus.models.Parcelas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcelasRepository extends JpaRepository<Parcelas, Long> {
    List<Parcelas> findByCartaoId(Long cartaoId);
}
