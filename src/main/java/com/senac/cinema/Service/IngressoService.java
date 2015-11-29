package com.senac.cinema.Service;

import com.senac.cinema.BaseRepository.CrudBD;
import com.senac.cinema.BaseRepository.TypeOperation;
import com.senac.cinema.Domain.Ingresso;
import com.senac.cinema.Repository.IngressoRepository;
import java.util.List;

public class IngressoService extends CrudBD<Ingresso>{
    private final IngressoRepository repository;
    
    public IngressoService() {
        this.repository = new IngressoRepository();
    }
    
    @Override
    public void save(Ingresso entity) {
        this.validateRules(entity, TypeOperation.Insert);
        this.repository.save(entity);
    }

    @Override
    public void delete(Ingresso entity) {
        this.validateRules(entity, TypeOperation.Delete);
        this.repository.delete(entity);
    }

    @Override
    public Ingresso search(Ingresso entity) {
        return this.repository.search(entity);
    }

    @Override
    public void update(Ingresso entity) {
        this.validateRules(entity, TypeOperation.Update);
        this.repository.update(entity);
    }

    @Override
    public List<Ingresso> search(String search) {
        return this.repository.search(search);
    }
    
    /*
    public HashMap<Integer, Ingresso> searchAll(){
        HashMap<Integer, Ingresso> hm = new HashMap<>();
        
        List<Ingresso> ingressoList = this.repository.searchAll();
        
        for (Ingresso ingresso : ingressoList) {
            if(ingresso == null) continue;
            
            hm.put(ingresso.getId(), ingresso);
        }
        
        return hm;
    }
    */
    
    private void validateRules(Ingresso entity, TypeOperation operation){
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
    
    private void validateInsert(Ingresso entity){
        if(entity == null)
            throw new IllegalArgumentException("Ingresso não informado.");
        
        if(entity.getId() > 0)
            throw new IllegalArgumentException("Ingresso não deve possuir ID.");
    }
    
    private void validateDelete(Ingresso entity){
        
    }
    
    private void validateUpdate(Ingresso entity){
        
    }

    public List<Ingresso> searchAll() {
        return this.repository.searchAll();
    }
}
