package com.senac.cinema.Repository;

import com.senac.cinema.Domain.Ingresso;
import com.senac.cinema.BaseRepository.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IngressoRepository extends CrudBD<Ingresso>{

    @Override
    public void save(Ingresso entity) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO ingresso  ");
            sql.append("(secaoId, valor)  ");
            sql.append("VALUES  ");
            sql.append("(?,?) ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getSecaoId());
            pstm.setDouble(2, entity.getValor());

            logger.debug("Salvando: " + entity);
            pstm.execute();
            commitTransacao(conn);
            logger.debug("Salvamento executado com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public void delete(Ingresso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ingresso search(Ingresso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Ingresso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ingresso> search(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
    /*
    public List<Ingresso> searchAll(){
        List<Ingresso> ingressoList = new ArrayList<>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM filme");

            logger.debug("Consultando todos filmes. ");
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                logger.debug("Registro encontrado");
                Ingresso result = new Ingresso();
                
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
    */
}
