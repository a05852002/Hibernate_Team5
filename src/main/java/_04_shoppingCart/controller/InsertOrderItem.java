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

@WebServlet("/_04_shoppingCart/InsertOrderItem.do")
public class InsertOrderItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(InsertOrderItem.class);
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
		OrderItemService orderItemService = new OrderItemService(session);

		System.out.println("開始找資料");
		int orderNo = Integer.valueOf(request.getParameter("orderNo"));
		System.out.println("開始找資料" + orderNo);
		_04_shoppingCart.model.OrderItemBean classList = orderItemService.selectOneOrdItem(orderNo);
		request.setAttribute("classList", classList);
		RequestDispatcher rd = request.getRequestDispatcher("/html/_04_shoppingCart/orderItemInsert.jsp");
		rd.forward(request, response);
		return;

	}
}
