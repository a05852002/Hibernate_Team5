package _02_subLocation.Servlet;

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

import _02_subLocation.dao.SubjectDao;
import _02_subLocation.dao.impl.SubjectDaoImpl;
import tw.hibernatedemo.util.HibernateUtil;

@MultipartConfig()
@WebServlet("/Servlet/subjectUpdatedata")
public class subjectUpdatedata extends HttpServlet {

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

		SubjectDao classService = new SubjectDaoImpl(session);
		System.out.println(request.getParameter("subNo"));
		int subNo = Integer.parseInt(request.getParameter("subNo"));
		String subName = request.getParameter("subName");
		String subClass = request.getParameter("subClass");
		try {
			classService.updateSubFromSubno(subNo, subName, subClass);
			RequestDispatcher rd = request.getRequestDispatcher("/Servlet/subjectSearch");
			rd.forward(request, response);
			return;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
