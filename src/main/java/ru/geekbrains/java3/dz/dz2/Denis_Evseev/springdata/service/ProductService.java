package ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.service;


import ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    List<Product> findByprodid(String prodid);

    List<Product> findBycostBetween(long cost1,long cost2);

    void setCostByProdid(String prodid,Long newCost);


    void save(Product product);

    void deleteAll ();
}
