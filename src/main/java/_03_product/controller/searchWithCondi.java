package _03_product.controller;

import java.io.IOException;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _03_product.model.ProdDaoService;
import _03_product.model.Product;

@WebServlet("/searchWithCondi")
public class searchWithCondi extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdDaoService pDao = new ProdDaoService();
		
		int order = Integer.parseInt(request.getParameter("case"));
		String type = request.getParameter("typecase");
		int low = Integer.parseInt(request.getParameter("lowprice"));
		int high = Integer.parseInt(request.getParameter("highprice"));
		String name = request.getParameter("searchName");
		
		List<Product> list = pDao.searchShit(type, low, high, name, order);
		request.setAttribute("allprodlist", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/_03_product/shopHome.jsp");
		rd.forward(request, response);
		return;
	}

}
