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

import _04_shoppingCart.service.OrderService;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_04_shoppingCart/InsertOrder.do")
public class InsertOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(InsertOrder.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		OrderService orderService = new OrderService(session);
		
		String memberId = request.getParameter("memberId");
		String shippingAddress = request.getParameter("shippingAddress");
		
		orderService.insertOrder(memberId, shippingAddress);;
		request.setAttribute("OrdersDao", orderService);
		RequestDispatcher rd = request.getRequestDispatcher("/_04_shoppingCart/SelectAll.do");
		rd.forward(request, response);
		return;
	}
}

