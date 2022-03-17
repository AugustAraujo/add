package com.augusto.add.Entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Aluno {

    public Aluno(int id, String nome, Date data_de_nascimento, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.data_de_nascimento = data_de_nascimento;
        this.turma = turma;
    }

    public Aluno() {

    }

    @ApiModelProperty(value = "ID do aluno")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ApiModelProperty(value = "Nome do aluno")
    @Column
    private String nome;

    @ApiModelProperty(value = "Data de nascimento do aluno")
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_de_nascimento;

    @ApiModelProperty(value = "ID da turma que o usuário está")
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

    public Date getDataDeNascimento() {
        return data_de_nascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        data_de_nascimento = dataDeNascimento;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
