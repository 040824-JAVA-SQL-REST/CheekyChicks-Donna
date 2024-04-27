package com.revature.ecommerce.dao;

import java.util.List;

public interface CrudDAO<T> {
T save(T obj);
T update(T obj);
boolean delete(String id);
List<T>findall();
T findByID(String id);
}
