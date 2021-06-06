package com.cloud.microservicemongo;

import lombok.Data;

@Data
public class Course{
    private String id;
    private String name;
    private Long price;

    public Course(String name, Long price) {
        this.name = name;
        this.price = price;
    }
}