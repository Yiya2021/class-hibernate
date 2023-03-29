package com.city.erp.servlet;

import com.city.erp.model.AreaModel;
import com.city.erp.service.IAreaService;
import com.city.erp.service.impl.AreaServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/product/toadd.do")
public class ProductToAddController extends HttpServlet {
    IAreaService service = new AreaServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("areaList", service.getListByAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("/product/add.jsp").forward(req, resp);
    }
}
