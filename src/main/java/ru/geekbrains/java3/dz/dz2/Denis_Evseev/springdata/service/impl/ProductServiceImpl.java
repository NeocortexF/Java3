package ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.entities.Product;
import ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.service.ProductService;
import ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.repository.ProductRepository;

import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return Lists.newArrayList(productRepository.findAll());
    }

    public List<Product> findByprodid(String prodid) {
        return productRepository.findByprodid(prodid);
    }

    public List<Product> findBycostBetween(long cost1, long cost2) {
        return productRepository.findBycostBetween(cost1,cost2);
    }

    public void setCostByProdid(String prodid, Long newCost) {
         productRepository.setCostByProdid(prodid,newCost);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }
}
