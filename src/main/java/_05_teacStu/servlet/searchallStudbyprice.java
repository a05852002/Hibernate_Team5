package _05_teacStu.servlet;

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

import _05_teacStu.model.tableForStud;
import _05_teacStu.model.teacAndStudDao;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_05_teacStu/searchallStudbyprice")
public class searchallStudbyprice extends HttpServlet {
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
		String lowstr = request.getParameter("low");
		String highstr = request.getParameter("high");
		if (lowstr.equals("最低時薪") || lowstr.equals("")) {
			lowstr="0";
		}
		if (highstr.equals("最高時薪") || highstr.equals("")) {
			highstr="999999999";
		}
		Integer low = Integer.valueOf(lowstr);
		Integer high = Integer.valueOf(highstr);
		List<tableForStud> classlist = classService.searchStudByPrice(low, high);
		request.setAttribute("classList", classlist);
		RequestDispatcher rd = request.getRequestDispatcher("/html/_05_teacStu/studCRUD.jsp");
		rd.forward(request, response);
	}

}
