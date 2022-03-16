package com.augusto.add.Repository;

import com.augusto.add.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Timestamp;

public interface EnderecoRepository  extends JpaRepository<Endereco, Integer> {
    @Modifying
    @Transactional
    @Query("update Endereco e set e.logradouro = :logradouro, e.bairro = :bairro, e.cidade = :cidade, e.complemento = :complemento, e.estado = :estado where e.id = :id")
    Void updateEndereco(int id, String logradouro, String bairro, String cidade, String complemento, String estado);
}
