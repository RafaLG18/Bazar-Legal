package com.bazarLegal.bazarlegal.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bazarLegal.bazarlegal.model.entidades.Lote;


public class RepositorioLote {

    List<Lote> lotes = new ArrayList<Lote>();
    
    RepositorioProduto repoP= new RepositorioProduto();
    RepositorioOrgaoDonatario repoD= new RepositorioOrgaoDonatario();
    RepositorioOrgaoFiscalizador repoF= new RepositorioOrgaoFiscalizador();

    public void create(Lote lote) throws SQLException {
        String sql = "insert into lote (data_entrega, observacao, id_orgaodonatario, id_orgaofiscalizador) " + "values(?,?,?,?)" + "returning id";

        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setDate(1, new java.sql.Date(lote.getDataEntrega().getTime()));
            pstm.setString(2, lote.getObservacao());
            pstm.setInt(3, lote.getOrgaoDonatarioId());
            pstm.setInt(4, lote.getOrgaoFiscalizadorId());

            ResultSet query = pstm.executeQuery();
            while (query.next()) {
                lote.setId(query.getInt("id"));

            }
            // Atualiza Produtos com o id do lote cadastrado
            this.repoP.update(lote);
            lote.setProdutosSelecionados(this.repoP.getAll(lote.getId()));
            lote.setOrgaoDonatario(this.repoD.read(lote.getOrgaoDonatarioId()));
            lote.setOrgaoFiscalizador(this.repoF.read(lote.getOrgaoFiscalizadorId()));
        }
    
        
        
    }

    // public Lote read(int key) throws SQLException {
    //     String sql = "select * from lote where id="+"?";

    //     try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {
    //         pstm.setInt(1, key);
    //         ResultSet query = pstm.executeQuery();
    //         while (query.next()) {
    //             Lote lote = new Lote();

    //             Date dataEntrega=query.getDate("data_entrega");
    //             String observacao= query.getString("observacao");
    //             OrgaoDonatario orgaoD = repoD.read(query.getInt("id_orgaodonatario"));
    //             OrgaoFiscalizador orgaoF = repoF.read(query.getInt("id_orgaofiscalizador"));

    //             lote.setId(key);
    //             lote.setDataEntrega(dataEntrega);
    //             lote.setObservacao(observacao);
    //             lote.setOrgaoDonatarioId(orgaoD);
    //             lote.setOrgaoFiscalizadorId(orgaoF);
    //             lote.setProdutosSelecionadosIds(repoP.getAll(key));
                
    //             return lote;
    //         }
    //     }
    //     return null;
    // }

    public List<Lote> getAll() throws SQLException {
        String sql = "select * from lote";

        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {

            ResultSet query = pstm.executeQuery();
            while (query.next()) {
                Lote lote = new Lote();

                int id_lote=query.getInt("id");
                Date dataEntrega=query.getDate("data_entrega");
                String observacao= query.getString("observacao");
                int orgaoDId = query.getInt("id_orgaodonatario");
                int orgaoFId = query.getInt("id_orgaofiscalizador");

                lote.setId(id_lote);
                lote.setDataEntrega(dataEntrega);
                lote.setObservacao(observacao);
                lote.setOrgaoDonatarioId(orgaoDId);
                lote.setOrgaoFiscalizadorId(orgaoFId);
                lote.setProdutosSelecionadosIds(repoP.read(id_lote));
                lote.setProdutosSelecionados(this.repoP.getAll(lote.getId()));
                lote.setOrgaoDonatario(this.repoD.read(lote.getOrgaoDonatarioId()));
                lote.setOrgaoFiscalizador(this.repoF.read(lote.getOrgaoFiscalizadorId()));
                
                lotes.add(lote);
            }
            return lotes;
        }
    }

}
