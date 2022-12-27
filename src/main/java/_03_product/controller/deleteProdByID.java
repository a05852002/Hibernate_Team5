package _03_product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _03_product.model.ProdDaoService;

@WebServlet("/deleteProdByID")
public class deleteProdByID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		int prodID = Integer.valueOf(request.getParameter("id"));
		ProdDaoService pDao = new ProdDaoService();
		try {
			pDao.deleteProdFromProdID(prodID);
			RequestDispatcher rd = request.getRequestDispatcher("/web/searchingProd");
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;

	}

}
