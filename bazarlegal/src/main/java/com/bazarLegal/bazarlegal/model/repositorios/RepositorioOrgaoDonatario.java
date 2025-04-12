package com.bazarLegal.bazarlegal.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bazarLegal.bazarlegal.model.entidades.OrgaoDonatario;


public class RepositorioOrgaoDonatario {
    List<OrgaoDonatario> orgaos= new ArrayList<OrgaoDonatario>();

    public void create(OrgaoDonatario orgaoDonatario) throws SQLException {
        String sql = "insert into orgaodonatario (nome, endereco, telefone, horario_funcionamento, descricao) " + "values(?,?,?,?,?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);

        // pstm.setInt(1, orgaoDonatario.getId());
        pstm.setString(1, orgaoDonatario.getNome());
        pstm.setString(2, orgaoDonatario.getEndereco());
        pstm.setString(3, orgaoDonatario.getTelefone());
        pstm.setString(4, orgaoDonatario.getHorarioFuncionamento());
        pstm.setString(5, orgaoDonatario.getDescricao());
        pstm.execute();
    }

    public OrgaoDonatario read(int key) throws SQLException{
        OrgaoDonatario orgao= new OrgaoDonatario();
        String sql="select * from orgaodonatario where id="+"?";
        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setInt(1, key);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                orgao.setId(key);
                orgao.setNome(query.getString("nome"));
                orgao.setEndereco(query.getString("endereco"));
                orgao.setTelefone(query.getString("telefone"));
                orgao.setHorarioFuncionamento(query.getString("horario_funcionamento"));
                orgao.setDescricao(query.getString("descricao"));
            }
            return orgao;
        }
    }
    public List<OrgaoDonatario> getAll() throws SQLException{
        String sql="select * from orgaodonatario";

        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                OrgaoDonatario orgao=new OrgaoDonatario();
                orgao.setId(query.getInt("id"));
                orgao.setNome(query.getString("nome"));
                orgao.setEndereco(query.getString("endereco"));
                orgao.setTelefone(query.getString("telefone"));
                orgao.setHorarioFuncionamento(query.getString("horario_funcionamento"));
                orgao.setDescricao(query.getString("descricao"));
                orgaos.add(orgao);
            }
            return orgaos;
        }
    }
}
