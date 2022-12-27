package _04_shoppingCart.controller;

import java.io.IOException;
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

import _04_shoppingCart.model.OrderBean;
import _04_shoppingCart.service.OrderService;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_04_shoppingCart/searchOrderServlet.do")
public class searchOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(searchOrderServlet.class);
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

		String search = request.getParameter("search");

		List<OrderBean> classList = orderService.searchAllorders(search);

		request.setAttribute("classList", classList);
		RequestDispatcher rd = request.getRequestDispatcher("/html/_04_shoppingCart/ordersCRUD.jsp");
		rd.forward(request, response);

	}

}
