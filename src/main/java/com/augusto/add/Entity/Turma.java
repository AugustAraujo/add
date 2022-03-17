package com.augusto.add.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
public class Turma {

    public Turma(int id, String nome, int capacidade, Escola escola) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.escola = escola;
    }

    public Turma() {

    }

    @ApiModelProperty(value = "ID da turma")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ApiModelProperty(value = "Nome da turma")
    @Column
    private String nome;

    @ApiModelProperty(value = "Capacidade da turma")
    @Column
    private int capacidade;

    @ApiModelProperty(value = "ID da escola")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_escola", referencedColumnName = "id")
    private Escola escola;

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

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }
}
