package com.city.erp.model;

import com.city.oa.model.PackagingModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

//PNO	Int(10)
//PName	Varchar(100)
//PDATE	DATETIME
//UNITPRICE	Decimal(10,2)
//QTY	Int(10)
@Data
@Entity
@Table(name = "erp_productsss")
public class ProductModel {
    @Id
    @Column(name = "PNO")
    @GeneratedValue(generator = "keyGenerator")
    @GenericGenerator(
            name = "keyGenerator",
            strategy = "foreign",
            parameters =@org.hibernate.annotations.Parameter(name = "property", value = "packagingModel")
    )
    private int pno = 0;
    @Column(name = "PName")
    private String pname = null;
    @Column(name = "PDATE")
    private String pdate = null;
    @Column(name = "UNITPRICE")
    private double unitprice = 0;
    @Column(name = "QTY")
    private int qty = 0;

    @ManyToMany(cascade = {CascadeType.REMOVE})
    @JoinTable(name = "erp_productarea",joinColumns = {@JoinColumn(name = "PNO")},inverseJoinColumns = {@JoinColumn(name = "ANo")})
    private Set<AreaModel> areaModelSet = null;

    @OneToOne
    @PrimaryKeyJoinColumn
    private PackagingModel packagingModel = null;
}
