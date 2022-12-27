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

@WebServlet("/_04_shoppingCart/DeleteOrder.do")
public class DeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(DeleteOrder.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		OrderService orderService = new OrderService(session);
		int orderNo = Integer.valueOf(request.getParameter("orderNo"));
		orderService.deleteOrderNo(orderNo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/_04_shoppingCart/SelectAll.do");
		rd.forward(request, response);
		return;
	}

}
