package com.senac.cinema.BaseRepository;

import java.util.List;

public interface ICrud<T> {
    void save(T entity);
    void delete(T entity);
    T search(T entity);
    void update(T entity);
    List<T> search(String search);    
}
