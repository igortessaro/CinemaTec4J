package com.senac.cinema.Repository;

import com.senac.cinema.Domain.Filme;
import com.senac.cinema.BaseRepository.CrudBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
