package com.bazarLegal.bazarlegal.model.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bazarLegal.bazarlegal.model.entidades.Lote;
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

    public void update(Lote lote) throws SQLException{
        List<Integer> produtosSelecionadosId=lote.getProdutosSelecionadosIds();
        for (int produtoId : produtosSelecionadosId) {
            this.update(lote,produtoId);
        }        
    }

    public void update(Lote lote, int produtoId) throws SQLException{
        String sql="update produto set id_lote = ? where codigo = ?";

        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);) {
			pstm.setInt(1, lote.getId());
			pstm.setInt(2, produtoId);

			pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    // Retorno lista dos Ids de produtos relacionados ao Lote
    public List<Integer> read(int key) throws SQLException{
        String sql="select codigo from produto where id_lote ="+"?";
        
        List<Integer> ids= new ArrayList<Integer>();
        int id;

        try(PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);) {
			pstm.setInt(1, key);
            ResultSet query = pstm.executeQuery();
            while (query.next()) { 
                id=query.getInt("codigo");
                ids.add(id);
            }
            return ids;
        }
    }

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
