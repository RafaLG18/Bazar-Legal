package com.bazarLegal.bazarlegal.model.entidades;

import java.util.Date;
import java.util.List;

public class Lote {

    private int id;
    private Date dataEntrega;
    private String observacao;
    private int id_orgaoDonatario;
    private int id_orgaoFiscalizador;

    private List<Produto> produtos;
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataEntrega() {
        return this.dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getId_orgaoDonatario() {
        return this.id_orgaoDonatario;
    }

    public void setId_orgaoDonatario(int id_orgaoDonatario) {
        this.id_orgaoDonatario = id_orgaoDonatario;
    }

    public int getId_orgaoFiscalizador() {
        return this.id_orgaoFiscalizador;
    }

    public void setId_orgaoFiscalizador(int id_orgaoFiscalizador) {
        this.id_orgaoFiscalizador = id_orgaoFiscalizador;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
