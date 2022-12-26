package _02_subLocation.locServlet;

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

import _02_subLocation.dao.LocationDao;
import _02_subLocation.dao.impl.LocationDaoImpl;
import _02_subLocation.model.LocationBean;
import tw.hibernatedemo.util.HibernateUtil;


@WebServlet("/locServlet/locationCreateServlet")
public class locationCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(locationCreateServlet.class);

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
		
		LocationBean locationBean = new LocationBean();

		
		int locNo = Integer.valueOf(request.getParameter("locno"));
		String locName = request.getParameter("locname");
		String locClass = request.getParameter("locclass");
		
		locationBean.setLocno(locNo);
		locationBean.setLocname(locName);
		locationBean.setLocclass(locClass);
		
		LocationDao classService = new LocationDaoImpl(session);
		classService.add(locationBean);
		request.setAttribute("classService", classService);
		RequestDispatcher rd = request.getRequestDispatcher("/locServlet/locationSearch");
		rd.forward(request, response);
		return;

	}
}
