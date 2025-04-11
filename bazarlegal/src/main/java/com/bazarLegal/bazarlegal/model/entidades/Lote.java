package com.bazarLegal.bazarlegal.model.entidades;

import java.util.Date;
import java.util.List;

public class Lote {

    private int id;
    private Date dataEntrega;
    private String observacao;
    
    private OrgaoDonatario orgaoDonatario;
    private OrgaoFiscalizador orgaoFiscalizador;

    private List<Produto> produtosSelecionados;

    // Manipulação dos próprios atributos
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

    // Manipulacao das outras classes
    public OrgaoDonatario getOrgaoDonatario() {
        return this.orgaoDonatario;
    }

    public void setOrgaoDonatario(OrgaoDonatario orgao) {
        this.orgaoDonatario = orgao;
    }

    public OrgaoFiscalizador getOrgaoFiscalizador() {
        return this.orgaoFiscalizador;
    }

    public void setOrgaoFiscalizador(OrgaoFiscalizador orgao) {
        this.orgaoFiscalizador = orgao;
    }

    public List<Produto> getProdutosSelecionados() {
        return produtosSelecionados;
    }

    public void setProdutosSelecionados(List<Produto> produtosSelecionados) {
        this.produtosSelecionados = produtosSelecionados;
    }
}
