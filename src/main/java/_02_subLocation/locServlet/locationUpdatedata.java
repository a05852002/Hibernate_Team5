package _02_subLocation.locServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _02_subLocation.dao.LocationDao;
import _02_subLocation.dao.impl.LocationDaoImpl;
import tw.hibernatedemo.util.HibernateUtil;

@MultipartConfig()
@WebServlet("/locServlet/locationUpdatedata")
public class locationUpdatedata extends HttpServlet {

	private static final long serialVersionUID = 1L;

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

		LocationDao classService = new LocationDaoImpl(session);
		
		System.out.println(request.getParameter("locNo"));
		int locNo = Integer.parseInt(request.getParameter("locNo"));
		String locName = request.getParameter("locName");
		String locClass = request.getParameter("locClass");
		try {
			classService.updateLocFromLocno(locNo, locName, locClass);
			RequestDispatcher rd = request.getRequestDispatcher("/locServlet/locationSearch");
			rd.forward(request, response);
			return;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
