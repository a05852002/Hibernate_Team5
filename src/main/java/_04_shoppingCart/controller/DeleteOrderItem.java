package _04_shoppingCart.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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

import _04_ShoppingCart.dao.OrdersDao;
import _04_ShoppingCart.dao.OrdersItemDao;
import _04_ShoppingCart.model.OrderItemBean;
import _04_shoppingCart.service.OrderItemService;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_04_shoppingCart/DeleteOrderItem.do")
public class DeleteOrderItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(DeleteOrderItem.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		OrderItemService orderItemService = new OrderItemService(session);
		
		int seqno = Integer.valueOf(request.getParameter("seqno"));
		
		
		
		
		Set<OrderItemBean> classList = orderItemService.selectAllOrdItem(oNo);

		OrdersItemDao classService = new OrdersItemDao();
		int seqno = Integer.valueOf(request.getParameter("seqno"));
		System.out.println("seqno " + seqno);
		try {
			List<OrderItemBean> classlist = classService.searchSeqnoByOrderNo(seqno);
			System.out.println("classList " + classlist);
			Integer orderNo = classlist.get(0).getOrderNo();
			System.out.println("orderNo " + orderNo);
			classService.deleteOrderItemNo(orderNo,seqno);
			request.setAttribute("classList", classlist);
			RequestDispatcher rd = request.getRequestDispatcher("/_04_ShoppingCart/searchAllServlet");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
