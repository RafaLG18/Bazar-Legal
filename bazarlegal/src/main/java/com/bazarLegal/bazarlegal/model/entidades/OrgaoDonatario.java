package com.bazarLegal.bazarlegal.model.entidades;

public class OrgaoDonatario {

    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String horarioFuncionamento;
    private String descricao;

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getHorarioFuncionamento() {
        return this.horarioFuncionamento;
    }

    // Setter e Getter para descricao
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
