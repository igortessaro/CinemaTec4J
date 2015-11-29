package com.senac.cinema.Repository;

import com.senac.cinema.Domain.Secao;
import com.senac.cinema.BaseRepository.CrudBD;
import com.senac.cinema.Domain.Filme;
import com.senac.cinema.Domain.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SecaoRepository extends CrudBD<Secao>{
    private FilmeRepository filmeRepository;
    private SalaRepository salaRepository;
    
    public SecaoRepository(){
        this.filmeRepository = new FilmeRepository();
        this.salaRepository = new SalaRepository();
    }
    
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
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM secao  ");
            sql.append("WHERE  ");
            sql.append("id = ?  ");

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getId());

            logger.debug("Excluido: " + entity);
            pstm.execute();
            commitTransacao(conn);
            logger.debug("Excluido com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public Secao search(Secao entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Secao entity) {
        Connection conn = null;
        try {
            conn = abrirConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE secao  ");
            sql.append("SET  ");
            sql.append(" salaId = ? ");
            sql.append(", filmeId = ? ");
            sql.append(", tempoDuracaoMinutos = ? ");
            sql.append(", dataHoraInicio = ? ");
            sql.append(" WHERE id = ? ");            

            PreparedStatement pstm = conn.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getSalaId());
            pstm.setInt(2, entity.getFilmeId());
            pstm.setInt(3, entity.getTempoDuracaoMinutos());
            pstm.setDate(4, new java.sql.Date(entity.getDataHoraInicio().getTime()));  
            pstm.setInt(5, entity.getId());

            logger.debug("Atualizado: " + entity);
            pstm.execute();
            commitTransacao(conn);
            logger.debug("Atualizado com sucesso");
        } catch (Exception e) {
            rollbackTransacao(conn);
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }
    }

    @Override
    public List<Secao> search(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    public List<Secao> searchAll() {
        List<Secao> secaoList = new ArrayList<>();
        
        Connection conn = null;
        try {
            conn = abrirConexao();

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM secao");

            logger.debug("Consultando todos filmes. ");
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Filme filme = null;
                Sala sala = null;
                
                logger.debug("Registro encontrado");
                Secao result = new Secao();
                result.setId(rs.getInt("id"));
                result.setDataHoraInicio(rs.getDate("dataHoraInicio"));
                result.setTempoDuracaoMinutos(rs.getInt("tempoDuracaoMinutos"));
                result.setFilmeId(rs.getInt("filmeId"));
                result.setSalaId(rs.getInt("salaId"));
                
                int filmeId = result.getFilmeId();
                
                if(filmeId > 0)
                    filme = this.filmeRepository.searchByID(filmeId);
                
                if(filme != null)
                    result.setFilme(filme);
                
                int salaId = result.getSalaId();
                
                if(salaId > 0)
                    sala = this.salaRepository.searchById(salaId);
                
                if(sala != null)
                    result.setSala(sala);
                
                secaoList.add(result);
            }
            logger.debug("Consulta executada com sucesso");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fecharConexao(conn);
        }        
        
        return secaoList;
    }
}
