package com.phoenix.clienteapp.models;

public class Product  {

    private int id;
    private String name;
    private String description;
    private String status;

    public Product() {

    }

    public Product(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = "1";
    }
    
    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + '}';
    }

}
