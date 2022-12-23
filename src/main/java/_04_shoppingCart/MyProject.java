package _04_shoppingCart;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _04_shoppingCart.dao.OrderDao;
import _04_shoppingCart.dao.OrderItemDao;
import _04_shoppingCart.model.OrderBean;
import _04_shoppingCart.model.OrderItemBean;
import _04_shoppingCart.service.OrderService;
import tw.hibernatedemo.model.Books;
import tw.hibernatedemo.util.HibernateUtil;

public class MyProject {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
//			OrderDao orderDao = new OrderDao(session);
//			OrderService orderService = new OrderService(session);
//			OrderBean order = orderService.insertOrder("333", "台北");
//			OrderBean order = new OrderBean();
			OrderBean order = session.get(OrderBean.class, 15);
//			System.out.println(order.toString());
			OrderItemDao orderItemDao = new OrderItemDao(session);
			OrderItemBean ordItem = orderItemDao.insertOrder("123545", "讚讚", 1, 200,1.0, "無");
			ordItem.setOrderbean(order);
//			
			Set<OrderItemBean> orderItemBean = new LinkedHashSet<OrderItemBean>();
			orderItemBean.add(ordItem);
			order.setItems(orderItemBean);
			session.save(order);

//			OrderBean findByOrderNo = orderDao.findByOrderNo(1);
//			List<OrderBean> selectAll = orderService.selectAll();
//			List<OrderBean> searchOrderByONo = orderService.searchOrderByONo(3);
//			List<OrderBean> searchAllorders = orderDao.searchAllorders("11111");
//			System.out.println("searchOrderByONo :"+searchOrderByONo);

//			List<OrderBean> selectAll = orderDao.selectAll();
//			for(OrderBean o:selectAll) {
//				System.out.println("id: "+o.getOrderNo());
//				System.out.println("name: "+o.getMemberId());
//			}

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ROLLBACK!!!");
			e.printStackTrace();
			session.getTransaction().rollback();

		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
