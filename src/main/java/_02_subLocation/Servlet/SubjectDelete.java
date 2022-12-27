package _02_subLocation.Servlet;

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

import _02_subLocation.dao.SubjectDao;
import _02_subLocation.dao.impl.SubjectDaoImpl;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/Servlet/SubjectDelete.do")
public class SubjectDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(SubjectDelete.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		SubjectDao sDao = new SubjectDaoImpl(session);
		 int subNo = Integer.valueOf( request.getParameter("subNo"));
			sDao.deleteSubfromSubno(subNo);
			RequestDispatcher rd = request.getRequestDispatcher("/Servlet/subjectSearch");
			rd.forward(request, response);
			return;
	}

}
