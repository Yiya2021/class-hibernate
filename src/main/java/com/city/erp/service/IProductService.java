package com.city.erp.service;

import com.city.erp.model.ProductModel;

public interface IProductService {
    public int add(ProductModel pm) throws Exception;//增加产品同时增加产品包装，先增加产品，再增加包装类型数据，返回产品号

    public void addArea(int productNo, int areaNo) throws Exception; //给指定产品增加指定区域。每次增加一个区域。

    public void addAreas(int productNo, int[] areaNos) throws Exception; //给指定产品增加多个区域。

}
