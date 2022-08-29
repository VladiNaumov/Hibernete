package com.naumdeveloper.homework.model;

import com.naumdeveloper.homework.model.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")

@NamedQueries({
        @NamedQuery(name = "findAll", query = "Select u from Customer u"),
        @NamedQuery(name = "countAll", query = "Select count(u) from Customer u"),
        @NamedQuery(name = "deleteById", query = "delete from Customer u where u.id = :id")
})

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
   // @Column(name = "title", nullable = false, unique = true)
    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "customer")
    private List<Product> product;

    public Customer() {
    }

    public Customer(String name, List<Product> product) {
        this.name = name;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return  String.format("Customer [id = %d, title = %s, customer_count = %d]", id, name, product.size());
    }
}
