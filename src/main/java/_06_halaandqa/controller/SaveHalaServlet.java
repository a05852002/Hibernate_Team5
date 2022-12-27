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

import _06_halaandqa.model.HalaBean;
import _06_halaandqa.model.HalaDao;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/SaveHalaServlet")
public class SaveHalaServlet extends HttpServlet {
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
		int halaId = 0;
		String takeId = request.getParameter("halaId");
		halaId = Integer.parseInt(takeId);
		try {
			HalaInterface hd = new HalaService(session);
			HalaBean beans = hd.findHalaId(halaId);
			System.out.println(beans);
			request.setAttribute("bean", beans);
			RequestDispatcher rd = request.getRequestDispatcher("/html/_06_hala/updateHala.jsp");
			rd.forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
}
