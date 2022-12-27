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

import _04_shoppingCart.service.OrderItemService;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_04_shoppingCart/OrderItemUpdate.do")
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

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		OrderItemService orderItemService = new OrderItemService(session);
		Integer orderNo = Integer.parseInt(request.getParameter("orderNo"));
		Integer seqno = Integer.parseInt(request.getParameter("seqno"));
		Integer qty = Integer.parseInt(request.getParameter("qty"));
		Integer prodPrice = Integer.parseInt(request.getParameter("prodPrice"));
		Double discount = Double.parseDouble(request.getParameter("discount"));
		String remark = request.getParameter("remark");

		orderItemService.updateOrder(orderNo, seqno, qty, prodPrice, discount, remark);

		RequestDispatcher rd = request.getRequestDispatcher("/_04_shoppingCart/SelectAllOrdItem.do");
		rd.forward(request, response);

	}

}
