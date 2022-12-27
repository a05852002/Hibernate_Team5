package _03_product.controller;

import java.io.IOException;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _03_product.model.ProdDaoService;
import _03_product.model.Product;


@WebServlet("/web/searchingProd")
public class searchingProd extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdDaoService pDao = new ProdDaoService();
		
		List<Product> list = null;
		try {
			list = pDao.searchAllProduct();
			System.out.println("5");
			request.setAttribute("allprodlist", list);
		} catch (SQLException e) {
			System.out.println("5.catch");
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/_03_product/shopHome.jsp");
		rd.forward(request, response);
		return;
	}

}
