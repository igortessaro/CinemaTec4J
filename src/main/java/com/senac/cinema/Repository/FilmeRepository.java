package com.senac.cinema.Repository;

import com.senac.cinema.Domain.Filme;
import com.senac.cinema.BaseRepository.CrudBD;
import com.senac.cinema.Domain.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FilmeRepository extends CrudBD<Filme>{

    @Override
    public void save(Filme entity) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO filme  ");
            sql.append("(nome, genero, sinopse)  ");
            sql.append("VALUES  ");
            sql.append("(?,?,?) ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNome());
            pstm.setInt(2, entity.getGenero().getValue());
            pstm.setString(3, entity.getSinopse());

            //logger.debug("Salvando: " + bean);
            pstm.execute();
            commitTransacao(conn);
            //logger.debug("Salvamento executado com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public void delete(Filme entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Filme search(Filme entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Filme entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Filme> search(String search) {
        List<Filme> filmeList = new ArrayList<>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM filme WHERE nome like ?");
            pstm.setString(1, "%" + search + "%");

            logger.debug("Consultando: " + search);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                logger.debug("Registro encontrado");
                Filme filmeResult = new Filme();
                
                filmeResult.setId(rs.getInt("id"));
                filmeResult.setNome(rs.getString("nome"));
                filmeResult.setGenero(Genero.fromInteger(rs.getInt("genero")));
                filmeResult.setSinopse(rs.getString("sinopse"));
                
                filmeList.add(filmeResult);
            }
            logger.debug("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }        
        
        return filmeList;
    }    
    
    public Filme searchByID(int id){
        
        Connection conn = null;        
        Filme result = null;
        
        try {
            conn = abrirConexao();
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM filme WHERE id=?");
            pstm.setInt(1, id);
            logger.debug("Consultando filme por id: " + id);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                logger.debug("Registro encontrado");
                result = new Filme();
                result.setId(rs.getInt("id"));
                result.setNome(rs.getString("nome"));
                result.setGenero(Genero.fromInteger(rs.getInt("genero")));
                result.setSinopse(rs.getString("sinopse"));
            }
            logger.debug("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.fecharConexao(conn);
        }
        
        return result;
    }
}
