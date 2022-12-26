package _04_shoppingCart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _04_ShoppingCart.dao.OrdersDao;
import _04_ShoppingCart.dao.OrdersItemDao;
import _04_ShoppingCart.model.OrderBean;

@WebServlet("/_04_ShoppingCart/OrderItemUpdate.do")
public class OrderItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(OrderItemUpdate.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		
		
		OrdersItemDao oItemDao = new OrdersItemDao();
		System.out.println(request.getParameter("orderNo"));
		int seqno = Integer.parseInt(request.getParameter("seqno"));
		String description = request.getParameter("description");
		int qty = Integer.parseInt(request.getParameter("qty"));
		Double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
		try {
			oItemDao.updateOrderFromOrderNo(seqno,description,qty, unitPrice);
//			RequestDispatcher rd = request.getRequestDispatcher("/_04_ShoppingCart/searchAllServlet");
			RequestDispatcher rd = request.getRequestDispatcher("/_04_ShoppingCart/searchItemServlet.do");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			System.out.println(request.getParameter("失敗"));
			e.printStackTrace();
		}
	}

}
