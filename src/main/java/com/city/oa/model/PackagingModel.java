package com.city.oa.model;

import com.city.erp.model.ProductModel;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "erp_productpackaging")
public class PackagingModel {
    @Id
    @Column(name = "PNO")
    private int pno = 0;
    @Column(name = "PTYPE")
    private String ptype = null;
    @Column(name = "PSIZE")
    private int psize = 0;


    @OneToOne(mappedBy="packagingModel",cascade=CascadeType.ALL,orphanRemoval = true,fetch=FetchType.EAGER)
    private ProductModel productModel = null;
}
