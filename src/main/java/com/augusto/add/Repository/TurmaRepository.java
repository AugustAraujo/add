package com.augusto.add.Repository;

import com.augusto.add.Entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface TurmaRepository  extends JpaRepository<Turma, Integer> {
    @Modifying
    @Transactional
    @Query("update Turma t set t.nome = :nome, t.capacidade = :capacidade where t.id = :id")
    Void updateTurma(int id, String nome, int capacidade);
}
