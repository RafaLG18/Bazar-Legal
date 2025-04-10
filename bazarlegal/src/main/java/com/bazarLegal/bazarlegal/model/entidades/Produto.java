package com.bazarLegal.bazarlegal.model.entidades;

public class Produto {

    private int codigo;
    private String nome;
    private String descricao;
    private int id_lote;

    // Getter e Setter para codigo
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Getter e Setter para nome
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para descricao
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Getter e Setter para id_lote
    public int getId_lote() {
        return this.id_lote;
    }

    public void setId_lote(int id_lote) {
        this.id_lote = id_lote;
    }
}
