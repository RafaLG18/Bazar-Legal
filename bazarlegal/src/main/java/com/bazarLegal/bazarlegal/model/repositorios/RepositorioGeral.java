package com.bazarLegal.bazarlegal.model.repositorios;

import java.sql.SQLException;
import java.util.List;

import com.bazarLegal.bazarlegal.model.entidades.Lote;
import com.bazarLegal.bazarlegal.model.entidades.OrgaoDonatario;
import com.bazarLegal.bazarlegal.model.entidades.OrgaoFiscalizador;
import com.bazarLegal.bazarlegal.model.entidades.Produto;



public class RepositorioGeral {

    RepositorioOrgaoDonatario orgD;
    RepositorioOrgaoFiscalizador orgF;
    RepositorioLote repoL;
    RepositorioProduto repoP;

    private static RepositorioGeral myself = new RepositorioGeral();

    public RepositorioGeral(){
        this.orgD=new RepositorioOrgaoDonatario();
        this.orgF=new RepositorioOrgaoFiscalizador();
        this.repoL=new RepositorioLote();
        this.repoP=new RepositorioProduto();
    }
    
    public static RepositorioGeral getCurrentInstance(){
        return myself;
    }

    public void create(OrgaoDonatario org) throws SQLException{
        this.orgD.create(org);
    }
    public void create(OrgaoFiscalizador org) throws SQLException{
        this.orgF.create(org);
    }
    public void create(Lote lote) throws SQLException{
        this.repoL.create(lote);       

    }
    public void create(Produto produto) throws SQLException{
        this.repoP.create(produto);
    }
    public List<OrgaoDonatario> readAllDonatarios() throws SQLException{
        return this.orgD.getAll();    
    }
    public List<OrgaoFiscalizador> readAllFiscalizadors() throws SQLException{
        return this.orgF.getAll();    
    }
    public List<Produto> readAllProduto() throws SQLException{
        return this.repoP.getAll();    
    }
    public List<Produto> readAllProdutoEscolhido(int key) throws SQLException{
        return this.repoP.getAll(key);    
    }
    
    public List<Lote> readAllLote() throws SQLException{
        return this.repoL.getAll();    
    }
}
