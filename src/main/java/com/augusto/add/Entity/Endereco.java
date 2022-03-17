package com.augusto.add.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Endereco implements Serializable {

    public Endereco(int id, String logradouro, String complemento, String bairro, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco() {

    }

    @ApiModelProperty(value = "ID do endereço")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ApiModelProperty(value = "Logradouro do endereço")
    @Column
    private String logradouro;

    @ApiModelProperty(value = "Complemento do endereço")
    @Column
    private String complemento;

    @ApiModelProperty(value = "Bairro do endereço")
    @Column
    private String bairro;

    @ApiModelProperty(value = "Cidade do endereço")
    @Column
    private String cidade;

    @ApiModelProperty(value = "Estado do endereço")
    @Column
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
