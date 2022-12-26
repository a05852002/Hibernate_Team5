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
import _02_subLocation.model.SubjectBean;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/Servlet/subjectCreateServlet")
public class subjectCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(subjectCreateServlet.class);

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
		
		SubjectBean subjectBean = new SubjectBean();
		
		int subNo = Integer.valueOf(request.getParameter("subno"));
		String subName = request.getParameter("subname");
		String subClass = request.getParameter("subclass");
		
		subjectBean.setSubjectId(subNo);
		subjectBean.setSubjectName(subName);
		subjectBean.setSubjectClass(subClass);
		
		
		SubjectDao classService = new SubjectDaoImpl(session);
		classService.add(subjectBean);
		request.setAttribute("classService", classService);
		RequestDispatcher rd = request.getRequestDispatcher("/Servlet/subjectSearch");
		rd.forward(request, response);
		return;

	}
}
