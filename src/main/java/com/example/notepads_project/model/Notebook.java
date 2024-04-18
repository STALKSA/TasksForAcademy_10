package com.example.notepads_project.model;

import lombok.Data;

@Data
public class Notebook {
    private int id;
    private String brand;
    private String name;
    private int pageAmount;
    private String cover;
    private String country;
    private String pageType;

}
