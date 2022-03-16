package com.augusto.add.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Aluno {

    public Aluno(int id, String nome, Timestamp dataDeNascimento, Turma turma) {
        this.id = id;
        this.nome = nome;
        DataDeNascimento = dataDeNascimento;
        this.turma = turma;
    }

    public Aluno() {

    }

    @GeneratedValue
    @Id
    private int id;

    @Column
    private String nome;

    @Column
    private Timestamp DataDeNascimento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_turma", referencedColumnName = "id")
    private Turma turma;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataDeNascimento() {
        return DataDeNascimento;
    }

    public void setDataDeNascimento(Timestamp dataDeNascimento) {
        DataDeNascimento = dataDeNascimento;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
