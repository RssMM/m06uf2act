package com.example.dao;

import com.example.modelo.Clients;

import java.util.List;

public interface Dao {
    Clients getById(int id);
    List<Clients> getAll();
    void save(Clients clients);
    void update(Clients clients);
    void delete(Clients clients);
}
