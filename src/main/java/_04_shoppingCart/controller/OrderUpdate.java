package _04_ShoppingCart;

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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _04_ShoppingCart.dao.OrdersDao;
import _04_ShoppingCart.model.OrderBean;
import _04_shoppingCart.service.OrderService;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_04_shoppingCart/OrderUpdate.do")
public class OrderUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(OrderUpdate.class);
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
		OrderService orderService = new OrderService(session);
		
		System.out.println(request.getParameter("orderNo"));
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		String memberId = request.getParameter("memberId");
		Date upOrderDate = new Date();
		String shippingAddress = request.getParameter("shippingAddress");
		Double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
		try {
			oDao.updateOrderFromOrderNo(orderNo, memberId,upOrderDate, shippingAddress, totalAmount);
			RequestDispatcher rd = request.getRequestDispatcher("/_04_ShoppingCart/searchAllServlet");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
