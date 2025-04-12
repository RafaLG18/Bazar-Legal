package com.bazarLegal.bazarlegal.model.entidades;

public class OrgaoFiscalizador {
    private int id;
    private String nome;
    private String descricao;

    public void setId(int id){
        this.id=id;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }
    public String getDescricao(){
        return this.descricao;
    }
}
