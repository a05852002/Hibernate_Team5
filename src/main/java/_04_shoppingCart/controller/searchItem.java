package _04_ShoppingCart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _04_ShoppingCart.dao.OrdersItemDao;
import _04_ShoppingCart.model.OrderItemBean;

@WebServlet("/_04_ShoppingCart/searchItem.do")
public class searchItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(searchItem.class);
	int pageNo = 1;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");  
		
		OrdersItemDao classService = new OrdersItemDao(); 
		  int seqno = Integer.valueOf( request.getParameter("seqno"));
		  System.out.println("seqno " + seqno);
			try {
				List<OrderItemBean> list = classService.searchSeqnoByOrderNo(seqno);
				System.out.println("list " + list);
				Integer orderNo = list.get(0).getOrderNo();
				List<OrderItemBean> classlist = classService.searchItem(orderNo,seqno);
				request.setAttribute("classList",classlist);
				RequestDispatcher rd = request.getRequestDispatcher("/html/order/orderItemUpdate.jsp");
				rd.forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
