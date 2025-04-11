package com.bazarLegal.bazarlegal.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bazarLegal.bazarlegal.model.entidades.Produto;

public class RepositorioProduto {

    
    public void create(Produto produto) throws SQLException {
        String sql="insert into produto (codigo, nome, descricao, id_lote) "+ "values(?,?,?,?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        
		pstm.setInt(1,produto.getCodigo());
        pstm.setString(2,produto.getNome());
		pstm.setString(3,produto.getDescricao());
        pstm.setInt(4,produto.getIdLote());
        pstm.execute();
    }


    // public void updateIdLote(Produto produto) throws SQLException{
    //     String sql="update produto set id_lote = "+"?"+"where id ="+"?";
    //     PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        
	// 	pstm.setInt(1,produto.getCodigo());
    //     pstm.setInt(2,produto.getIdLote());
    // }
    public List<Produto> getAll() throws SQLException{
        List<Produto> produtos= new ArrayList<Produto>();
        String sql="select * from produto ";

        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                Produto produto=new Produto();
                produto.setCodigo(query.getInt("codigo"));
                produto.setNome(query.getString("nome"));
                produto.setDescricao(query.getString("descricao"));
                produto.setIdLote(query.getInt("id_lote"));
                produtos.add(produto);
            }
            return produtos;
        }
    }
    public List<Produto> getAll(int key) throws SQLException{
        List<Produto> produtos= new ArrayList<Produto>();
        String sql="select * from produto where id_lote= "+"?";

        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)){
            pstm.setInt(1, key);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                Produto produto=new Produto();
                produto.setCodigo(query.getInt("codigo"));
                produto.setNome(query.getString("nome"));
                produto.setDescricao(query.getString("descricao"));
                produto.setIdLote(query.getInt("id_lote"));
                produtos.add(produto);
            }
            return produtos;
        }
    }
    
}
