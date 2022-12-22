package _05_teacStu.servlet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _05_teacStu.model.tableForTeac;
import _05_teacStu.model.teacAndStudDao;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_05_teacStu/switchsequence")
public class switchsequence extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		teacAndStudDao classService = new teacAndStudDao(session);
		String choose = request.getParameter("case");
		List<tableForTeac> classlist = new ArrayList<>();
		switch (choose) {
		case "1":
			classlist = classService.searchAllTeacOBmId();
			break;
		case "2":
			classlist = classService.searchAllTeacOBpDate();
			break;
		case "3":
			classlist = classService.searchAllTeacOBprice();
			break;
		default:
			classlist = classService.searchAllTeac();
			break;
		}
		request.setAttribute("classList", classlist);
		RequestDispatcher rd = request.getRequestDispatcher("/html/_05_teacStu/teacCRUD.jsp");
		rd.forward(request, response);
		return;
	}
}
