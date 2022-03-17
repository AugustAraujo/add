package com.augusto.add.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Escola implements Serializable {

    public Escola(int id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Escola() {

    }

    @ApiModelProperty(value = "ID da escola")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ApiModelProperty(value = "Nome da escola")
    @Column
    private String nome;

    @ApiModelProperty(value = "ID do endereço referente a escola")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private Endereco endereco;

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

    public Endereco getEndereco() { return endereco; }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
