package _06_halaandqa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _06_halaandqa.model.HalaDao;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/DeleteHalaServlet")
public class DeleteHalaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		request.setCharacterEncoding("utf-8");
		int id = Integer.valueOf(request.getParameter("halaId"));
		HalaInterface hd = new HalaService(session);
		try {
			hd.deleteHala(id);
			RequestDispatcher rd = request.getRequestDispatcher("/CrudServlet");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
