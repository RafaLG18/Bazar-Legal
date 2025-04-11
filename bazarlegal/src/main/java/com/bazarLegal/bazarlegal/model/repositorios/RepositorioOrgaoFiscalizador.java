package com.bazarLegal.bazarlegal.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bazarLegal.bazarlegal.model.entidades.OrgaoFiscalizador;

public class RepositorioOrgaoFiscalizador {

    List<OrgaoFiscalizador> orgaos= new ArrayList<OrgaoFiscalizador>();

    public void create(OrgaoFiscalizador orgaoFiscalizador) throws SQLException {
        String sql = "insert into orgaofiscalizador (nome, descricao) " + "values(?,?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        //pstm.setInt(1, orgaoFiscalizador.getId());
        pstm.setString(1, orgaoFiscalizador.getNome());
        pstm.setString(2, orgaoFiscalizador.getDescricao());
        pstm.execute();
    }
    
    public OrgaoFiscalizador read(int key) throws SQLException{
        OrgaoFiscalizador orgao= new OrgaoFiscalizador();
        String sql="select * from orgaofiscalizador where id="+"?";
        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setInt(1, key);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                orgao.setId(key);
                orgao.setNome(query.getString("nome"));
                orgao.setDescricao(query.getString("descricao"));
            }
            return orgao;
        }
    }
    public List<OrgaoFiscalizador> getAll() throws SQLException{
        String sql="select * from orgaofiscalizador";

        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                OrgaoFiscalizador orgao=new OrgaoFiscalizador();
                orgao.setId(query.getInt("id"));
                orgao.setNome(query.getString("nome"));
                orgao.setDescricao(query.getString("descricao"));
                orgaos.add(orgao);
            }
            return orgaos;
        }
    }

}
