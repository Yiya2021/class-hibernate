package com.city.erp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

//ANo	Int(10)
//AName	Varchar(20)
@Data
@Entity
@Table(name = "erp_areas")
public class AreaModel {
    @Id
    @Column(name = "ANo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ANo = 0;
    @Column(name = "AName")
    private String AName = null;

    @ManyToMany(mappedBy = "areaModelSet")
    private Set<ProductModel> productModelSet = null;
}
