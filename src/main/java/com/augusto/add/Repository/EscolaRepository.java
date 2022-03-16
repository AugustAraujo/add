package com.augusto.add.Repository;

import com.augusto.add.Entity.Endereco;
import com.augusto.add.Entity.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Timestamp;

public interface EscolaRepository extends JpaRepository <Escola, Integer>{
    @Modifying
    @Transactional
    @Query("update Escola e set e.nome = :nome, e.endereco = :endereco where e.id = :id")
    Void updateEscola(int id, String nome, Endereco endereco);
}
