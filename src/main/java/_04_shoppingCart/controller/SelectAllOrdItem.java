package _04_shoppingCart.controller;

import java.io.IOException;
import java.util.Set;

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

@WebServlet("/_04_shoppingCart/SelectAllOrdItem.do")
public class SelectAllOrdItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(SelectAllOrdItem.class);
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
		OrderItemService orderItemService = new OrderItemService(session);
		int oNo = Integer.valueOf(request.getParameter("orderNo"));
		Set<OrderItemBean> classList = orderItemService.selectAllOrdItem(oNo);
		request.setAttribute("classList", classList);
		RequestDispatcher rd = request.getRequestDispatcher("/html/_04_shoppingCart/ordersItemCRUD.jsp");
		rd.forward(request, response);
		return;
		
	}

}
