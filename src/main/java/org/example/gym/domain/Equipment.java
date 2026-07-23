package org.example.gym.domain;

public class Equipment {
    private Integer id;
    private String name;
    private String category;
    private Boolean isOperational;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Boolean getIsOperational() { return isOperational; }
    public void setIsOperational(Boolean isOperational) { this.isOperational = isOperational; }
}