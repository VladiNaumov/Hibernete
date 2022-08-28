package com.naumdeveloper.homework.model;

import com.naumdeveloper.homework.model.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customer")
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
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", product=" + product +
                '}';
    }
}
