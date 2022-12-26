package _02_subLocation.locServlet;

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

import _02_subLocation.dao.LocationDao;
import _02_subLocation.dao.impl.LocationDaoImpl;
import _02_subLocation.model.LocationBean;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/locServlet/locationSearch")
public class locationSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(locationSearch.class);

	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		LocationDao classService = new LocationDaoImpl(session);
		List<LocationBean> classlist = classService.searchAllLoc();
		request.setAttribute("classList", classlist);
		RequestDispatcher rd = request.getRequestDispatcher("/html/_02_subLocation/location/locCRUD.jsp");
		rd.forward(request, response);
		return;

	}
}
