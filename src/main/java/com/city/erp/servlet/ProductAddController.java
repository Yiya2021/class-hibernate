package com.city.erp.servlet;

import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;
import com.city.erp.service.impl.ProductServiceImpl;
import com.city.oa.model.PackagingModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/product/add.do")
public class ProductAddController extends HttpServlet {
    IProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int proId;
        ProductModel pm = new ProductModel();
        pm.setPname(req.getParameter("productName"));
        pm.setPdate(req.getParameter("productDate"));
        pm.setUnitprice(Double.parseDouble(req.getParameter("productPrice")));
        pm.setQty(Integer.parseInt(req.getParameter("productStock")));
        PackagingModel model = new PackagingModel();
        model.setPtype(req.getParameter("productPacking"));
        model.setPsize(Integer.parseInt(req.getParameter("productSize")));
        pm.setPackagingModel(model);
        try {
            proId =  productService.add(pm);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String[] areaIds = req.getParameterValues("areaId");
        int[] areaId = new int[areaIds.length];
        System.out.println(areaId);
        for (int i = 0; i < areaIds.length; i++) {
            areaId[i] = Integer.parseInt(areaIds[i]);
        }
        try {
            productService.addAreas(proId, areaId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
