package com.senac.cinema.Service;

import com.senac.cinema.BaseRepository.CrudBD;
import com.senac.cinema.BaseRepository.TypeOperation;
import com.senac.cinema.Domain.Sala;
import com.senac.cinema.Repository.SalaRepository;
import java.util.HashMap;
import java.util.List;

public class SalaService extends CrudBD<Sala>{
    private final SalaRepository repository;
    
    public SalaService(){
        this.repository = new SalaRepository();
    }
    
    @Override
    public void save(Sala entity) {
        this.validateRules(entity, TypeOperation.Insert);
        this.repository.save(entity);
    }

    @Override
    public void delete(Sala entity) {
        this.validateRules(entity, TypeOperation.Delete);
        this.repository.delete(entity);
    }

    @Override
    public Sala search(Sala entity) {
        return this.repository.search(entity);
    }

    @Override
    public void update(Sala entity) {
        this.validateRules(entity, TypeOperation.Update);
        this.repository.update(entity);
    }

    @Override
    public List<Sala> search(String search) {
        return this.repository.search(search);
    } 
    
    public List<Sala> obterPorNumero(int numero){
        return this.repository.searchAllByNumero(numero);
    }
    
    public List<Sala> obterTodos() {
        return this.repository.searchAll();
    }
    
    public HashMap<Integer, Sala> searchAll(){
        HashMap<Integer, Sala> hm = new HashMap<>();
        
        List<Sala> salaList = this.repository.searchAll();
        
        for (Sala sala : salaList) {
            if(sala == null) continue;
            
            hm.put(sala.getId(), sala);
        }
        
        return hm;
    }
    
    private void validateRules(Sala entity, TypeOperation operation){
        switch(operation){
            case Delete:
                this.validateDelete(entity);
                break;
            case Insert:
                this.validateInsert(entity);
                break;
            case Update:
                this.validateUpdate(entity);
                break;
        }
    }
    
    private void validateInsert(Sala entity){
        if(entity == null)
            throw new IllegalArgumentException("Sala não informada.");
        
        if(entity.getId() > 0)
            throw new IllegalArgumentException("Sala não deve possuir ID.");
        
        Sala sala = this.repository.searchByNumero(entity.getNumero());
        
        if(sala != null)
            throw new IllegalArgumentException("Sala já existente.");
    }
    
    private void validateDelete(Sala entity){
        if(entity.getId() == 0)
            throw new IllegalArgumentException("Código da sala não informado...");
    }
    
    private void validateUpdate(Sala entity){        
    }
}
