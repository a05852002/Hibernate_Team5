package _06_halaandqa.controller;

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

import _06_halaandqa.model.HalaBean;
import _06_halaandqa.model.QaBean;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/QaCrudServlet")
public class QaCrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		QaInterface classService = new QaService(session);
		List<QaBean> classlist;
		try {
			classlist = classService.findQaAll();
			request.setAttribute("classList", classlist);
			RequestDispatcher rd = request.getRequestDispatcher("/html/_06_hala/qa.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}