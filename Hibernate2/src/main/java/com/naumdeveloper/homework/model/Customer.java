package com.naumdeveloper.homework.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Customer")
@NamedQueries({
        @NamedQuery(name = "findAllCustomer", query = "SELECT u FROM Customer u"),
        @NamedQuery(name = "countAllCustomer", query = "SELECT count(u) FROM Customer u"),
        @NamedQuery(name = "deleteCustomer", query = "DELETE FROM Customer u WHERE u.id = :id")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title", nullable = false, unique = true)
    private String name;


    @OneToMany(mappedBy = "Product")
    private List<Product> products;

    public Customer() {
    }

    public Customer(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public Customer(String name) {
        this.name = name;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
