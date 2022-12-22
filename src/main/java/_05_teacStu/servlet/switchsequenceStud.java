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

import _05_teacStu.model.tableForStud;
import _05_teacStu.model.teacAndStudDao;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_05_teacStu/switchsequenceStud")
public class switchsequenceStud extends HttpServlet {
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
		List<tableForStud> classlist = new ArrayList<>();
		switch (choose) {
		case "1":
			classlist = classService.searchAllStudOBmId();
			break;
		case "2":
			classlist = classService.searchAllStudOBpDate();
			break;
		case "3":
			classlist = classService.searchAllStudOBprice();
			break;
		default:
			classlist = classService.searchAllStud();
			break;
		}
		request.setAttribute("classList", classlist);
		RequestDispatcher rd = request.getRequestDispatcher("/html/_05_teacStu/studCRUD.jsp");
		rd.forward(request, response);
		return;
	}
}
