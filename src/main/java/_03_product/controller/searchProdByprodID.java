package _03_product.controller;

import java.io.IOException;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _03_product.model.ProdDaoService;
import _03_product.model.Product;


@WebServlet("/searchProdByprodID")
public class searchProdByprodID extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 private static Logger log = LoggerFactory.getLogger(searchProdByprodID.class);
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	  
	  int prodID = 0;
	  String id = request.getParameter("id");
	  prodID = Integer.parseInt(id);
	  ProdDaoService pDao = new ProdDaoService();
	  
	  try {
		Product prod = pDao.searchSingleProductFromProdID(prodID);
		ArrayList<Product> prods = new ArrayList<Product>();
		prods.add(prod);
		request.setAttribute("bean", prods);
		RequestDispatcher rd = request.getRequestDispatcher("/_03_product/UpdateProd.jsp");
		rd.forward(request, response);
		return;
	  } catch (SQLException e) {
		e.printStackTrace();
	  }
	 
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	   throws ServletException, IOException {
	  doGet(request, response);
	 }
	}
