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

@WebServlet("/FindQaClassServlet")
public class FindQaClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			
			QaInterface hd = new QaService(session);
			String qaClassName = request.getParameter("QaClassName");
			List<QaBean> classList = hd.selectQa(qaClassName);
			request.setAttribute("classList", classList);
			RequestDispatcher rd = request.getRequestDispatcher("/html/_06_hala/qa.jsp");

			rd.forward(request, response);
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
