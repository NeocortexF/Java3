package ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>{
    List<Product> findByprodid(String prodid);
    List<Product> findBycostBetween(long cost1,long cost2);
    @Modifying
    void setCostByProdid(String prodid,Long newCost);
}
