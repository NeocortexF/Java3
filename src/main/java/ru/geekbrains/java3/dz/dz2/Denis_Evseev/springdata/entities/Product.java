package ru.geekbrains.java3.dz.dz2.Denis_Evseev.springdata.entities;

import javax.persistence.*;


@Entity
@NamedQuery(name = "Product.setCostByProdid",
        query = "update Product u set u.cost = ?2 where u.prodid = ?1")
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
//    @Column(name = "fname")
    private String prodid;
    private String title;
    private Long cost;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Product() {
    }

    public Product(String prodid, String title) {
        this.prodid = prodid;
        this.title = title;
    }

    public Product(Long id, String prodid, String title) {
        this.id = id;
        this.prodid = prodid;
        this.title = title;
    }

    public Product(Long id, String prodid, String title, Long cost) {
        this.id = id;
        this.prodid = prodid;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (!getId().equals(product.getId())) return false;
        if (getProdid() != null ? !getProdid().equals(product.getProdid()) : product.getProdid() != null) return false;
        if (getTitle() != null ? !getTitle().equals(product.getTitle()) : product.getTitle() != null) return false;
        return getCost() != null ? getCost().equals(product.getCost()) : product.getCost() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getProdid() != null ? getProdid().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getCost() != null ? getCost().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", prodid='" + prodid.trim() + '\'' +
                ", title='" + title.trim() + '\'' +
                ", cost=" + cost +
                '}';
    }
}
