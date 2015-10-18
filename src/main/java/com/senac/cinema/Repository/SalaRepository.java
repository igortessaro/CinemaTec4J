package com.senac.cinema.Repository;

import com.senac.cinema.Domain.Sala;
import com.senac.cinema.BaseRepository.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class SalaRepository extends CrudBD<Sala>{

    @Override
    public void save(Sala entity) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO sala  ");
            sql.append("(numero, quantidadeAssentos)  ");
            sql.append("VALUES  ");
            sql.append("(?,?) ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getNumero());
            pstm.setInt(2, entity.getQuantidadeAssentos());

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
    public void delete(Sala entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sala search(Sala entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Sala entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sala> search(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Sala searchByNumero(int numero){
        Connection conn = null;        
        Sala result = null;
        
        try {
            conn = abrirConexao();
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM sala WHERE numero=?");
            pstm.setInt(1, numero);
            logger.debug("Consultando sala por número: " + numero);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                logger.debug("Registro encontrado");
                result = new Sala();
                result.setId(rs.getInt("id"));
                result.setNumero(rs.getInt("numero"));
                result.setQuantidadeAssentos(rs.getInt("quantidadeAssentos"));
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
