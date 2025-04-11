package com.bazarLegal.bazarlegal.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bazarLegal.bazarlegal.model.entidades.Lote;
import com.bazarLegal.bazarlegal.model.entidades.OrgaoDonatario;
import com.bazarLegal.bazarlegal.model.entidades.OrgaoFiscalizador;

public class RepositorioLote {

    List<Lote> lotes = new ArrayList<Lote>();
    
    RepositorioOrgaoDonatario repoD= new RepositorioOrgaoDonatario();
    RepositorioOrgaoFiscalizador repoF= new RepositorioOrgaoFiscalizador();
    RepositorioProduto produto= new RepositorioProduto();

    public void create(Lote lote) throws SQLException {
        String sql = "insert into lote (id, data_entrega, observacao, id_orgaodonatario, id_orgaofiscalizador) " + "values(?,?,?,?,?,?)";

        OrgaoDonatario orgaoD = lote.getOrgaoDonatario();
        OrgaoFiscalizador orgaoF = lote.getOrgaoFiscalizador();

        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setInt(1, lote.getId());
        pstm.setDate(2, new java.sql.Date(lote.getDataEntrega().getTime()));
        pstm.setString(3, lote.getObservacao());
        pstm.setInt(4, orgaoD.getId());
        pstm.setInt(5, orgaoF.getId());
        pstm.execute();
    }

    public Lote read(int key) throws SQLException {
        String sql = "select * from lote where id="+"?";

        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {

            ResultSet query = pstm.executeQuery();
            while (query.next()) {
                Lote lote = new Lote();

                Date dataEntrega=query.getDate("data_entrega");
                String observacao= query.getString("observacao");
                OrgaoDonatario orgaoD = repoD.read(query.getInt("id_orgaodonatario"));
                OrgaoFiscalizador orgaoF = repoF.read(query.getInt("id_orgaofiscalizador"));

                lote.setId(key);
                lote.setDataEntrega(dataEntrega);
                lote.setObservacao(observacao);
                lote.setOrgaoDonatario(orgaoD);
                lote.setOrgaoFiscalizador(orgaoF);
                lote.setProdutosSelecionados(produto.getAll(key));
                
                return lote;
            }
        }
        return null;
    }

    public List<Lote> getAll() throws SQLException {
        String sql = "select * from lote";

        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {

            ResultSet query = pstm.executeQuery();
            while (query.next()) {
                Lote lote = new Lote();

                int id_lote=query.getInt("id");
                Date dataEntrega=query.getDate("data_entrega");
                String observacao= query.getString("observacao");
                OrgaoDonatario orgaoD = repoD.read(query.getInt("id_orgaodonatario"));
                OrgaoFiscalizador orgaoF = repoF.read(query.getInt("id_orgaofiscalizador"));

                lote.setId(id_lote);
                lote.setDataEntrega(dataEntrega);
                lote.setObservacao(observacao);
                lote.setOrgaoDonatario(orgaoD);
                lote.setOrgaoFiscalizador(orgaoF);
                lote.setProdutosSelecionados(produto.getAll(id_lote));
                
                lotes.add(lote);
            }
            return lotes;
        }
    }

}
