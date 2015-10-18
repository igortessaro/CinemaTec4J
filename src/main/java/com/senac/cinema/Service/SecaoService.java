package com.senac.cinema.Service;

import com.senac.cinema.BaseRepository.CrudBD;
import com.senac.cinema.BaseRepository.TypeOperation;
import com.senac.cinema.Domain.Secao;
import com.senac.cinema.Repository.SecaoRepository;
import java.util.HashMap;
import java.util.List;

public class SecaoService extends CrudBD<Secao>{
    private final SecaoRepository repository;    
    
    public SecaoService(){
        this.repository = new SecaoRepository();
    }
    
    @Override
    public void save(Secao entity) {
        this.validateRules(entity, TypeOperation.Insert);
        this.repository.save(entity);
    }

    @Override
    public void delete(Secao entity) {
        this.validateRules(entity, TypeOperation.Delete);
        this.repository.delete(entity);
    }

    @Override
    public Secao search(Secao entity) {
        return this.repository.search(entity);
    }

    @Override
    public void update(Secao entity) {
        this.validateRules(entity, TypeOperation.Update);
        this.repository.update(entity);
    }

    @Override
    public List<Secao> search(String search) {
        return this.repository.search(search);
    }    
    
    private void validateRules(Secao entity, TypeOperation operation){
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
    
    private void validateInsert(Secao entity){
        if(entity == null)
            throw new IllegalArgumentException("Sala não informada.");
        
        if(entity.getId() > 0)
            throw new IllegalArgumentException("Sala não deve possuir ID.");
    }
    
    private void validateDelete(Secao entity){        
    }
    
    private void validateUpdate(Secao entity){        
    }

    public HashMap<Integer, Secao> searchAll() {
        HashMap<Integer, Secao> hm = new HashMap<>();
        
        List<Secao> secaoList = this.repository.searchAll();
        
        for (Secao secao : secaoList) {
            if(secao == null) continue;
            
            hm.put(secao.getId(), secao);
        }
        
        return hm;
    }
}
