package com.senac.cinema.BaseRepository;

public interface ValidationRules<T> {
    void validateSave(T entity);
    void validateDelete(T entity);
    void validateSearch(T entity);
    void validateUpdate(T entity);
    
    void validate(T entity, TypeOperation operation);
}
