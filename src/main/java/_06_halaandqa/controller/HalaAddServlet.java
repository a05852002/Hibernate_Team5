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

@WebServlet("/HalaAddServlet")
public class HalaAddServlet extends HttpServlet {
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
		String halaClassName=request.getParameter("halaclassname");
		int memberId=Integer.valueOf(request.getParameter("memberid"));
		String title=request.getParameter("title");
		String halaContent=request.getParameter("halacontent");
		HalaBean ha= new HalaBean();
		try {
		HalaInterface hd=new HalaService(session);
		hd.insertHala(halaClassName,memberId,title,halaContent);
		request.setAttribute("hala", hd);
		RequestDispatcher rd=request.getRequestDispatcher("/CrudServlet");
		rd.forward(request, response);
		return;
		}catch (Exception e ) {
			e.printStackTrace();
		}
	}
}
	