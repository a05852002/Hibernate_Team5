package _04_shoppingCart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _04_shoppingCart.dao.OrderDao;
import _04_shoppingCart.model.OrderBean;
import _04_shoppingCart.service.OrderService;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_04_shoppingCart/SelectAll.do")
public class SelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(SelectAll.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		OrderService orderService = new OrderService(session);
		
		List<OrderBean> classlist = orderService.selectAll();
		request.setAttribute("classList", classlist);
		RequestDispatcher rd = request.getRequestDispatcher("/html/order/ordersCRUD.jsp");
		rd.forward(request, response);
		return;
	}

}
