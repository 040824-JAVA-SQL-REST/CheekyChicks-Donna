package com.revature.ecommerce.dao;

import java.util.List;

public interface CrudDAO<T> {
void save(T obj);
void update(T obj);
void delte(String id);
List<T>findall();
T findByID(String id);
}
