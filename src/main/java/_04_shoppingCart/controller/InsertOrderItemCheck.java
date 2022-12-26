package _04_shoppingCart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _04_shoppingCart.model.OrderItemBean;
import _04_shoppingCart.service.OrderItemService;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_04_shoppingCart/InsertOrderItemCheck.do")
public class InsertOrderItemCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(InsertOrderItemCheck.class);
//	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		OrderItemService orderItemService = new OrderItemService(session);
		
		Integer orderNo = Integer.parseInt(request.getParameter("orderNo"));
		String prodId = request.getParameter("prodId");
		String prodName = request.getParameter("prodName");
		Integer qty = Integer.parseInt(request.getParameter("qty"));
		Integer prodPrice = Integer.parseInt(request.getParameter("prodPrice"));
		Double discount = Double.valueOf(request.getParameter("discount"));
		String remark = request.getParameter("remark");
		OrderItemBean classList = orderItemService.insertOrder(orderNo, prodId, prodName, qty, prodPrice, discount, remark);
		request.setAttribute("classList", classList);
		RequestDispatcher rd = request.getRequestDispatcher("/_04_shoppingCart/SelectAll.do");
		rd.forward(request, response);
		return;
	}
}
