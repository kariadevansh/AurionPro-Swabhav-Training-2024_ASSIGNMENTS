package com.apro.model;


public interface OperationsInterface<T> {
    void get();
    void add(T entity);
    void update(T entity);
    void delete(int id);
    int checkExists(int id);
}
