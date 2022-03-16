package com.augusto.add.Repository;

import com.augusto.add.Entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Timestamp;

public interface AlunoRepository  extends JpaRepository<Aluno, Integer> {
    @Modifying
    @Transactional
    @Query("update Aluno a set a.nome = :nome, a.DataDeNascimento = :DataDeNascimento where a.id = :id")
    Void updateAluno(int id, String nome, Timestamp DataDeNascimento);
}
