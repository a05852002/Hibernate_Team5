package _05_teacStu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _05_teacStu.model.teacAndStudDao;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_05_teacStu/deletedataStud")
public class deletedataStud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		teacAndStudDao oDao = new teacAndStudDao(session);
		int studno = 0;
		studno = Integer.valueOf(request.getParameter("studno"));
		oDao.deleteStudfromStudno(studno);
		RequestDispatcher rd = request.getRequestDispatcher("/_05_teacStu/searchAllStudServlet");
		rd.forward(request, response);
		return;
	}
}
