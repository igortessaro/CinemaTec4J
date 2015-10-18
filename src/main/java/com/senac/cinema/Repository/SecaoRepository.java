package com.senac.cinema.Repository;

import com.senac.cinema.Domain.Secao;
import com.senac.cinema.BaseRepository.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class SecaoRepository extends CrudBD<Secao>{

    @Override
    public void save(Secao entity) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO secao  ");
            sql.append("(salaId, filmeId, dataHoraInicio, tempoDuracaoMinutos)  ");
            sql.append("VALUES  ");
            sql.append("(?,?,?,?) ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getSalaId());
            pstm.setInt(2, entity.getFilmeId());
            pstm.setDate(3, new java.sql.Date(entity.getDataHoraInicio().getTime()));
            pstm.setInt(4, entity.getTempoDuracaoMinutos());

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
    public void delete(Secao entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Secao search(Secao entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Secao entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Secao> search(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
