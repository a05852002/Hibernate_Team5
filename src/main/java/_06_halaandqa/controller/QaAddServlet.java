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
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/QaAddServlet")
public class QaAddServlet extends HttpServlet {
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
		String qaClassName=request.getParameter("qaclassname");
		int memberId=Integer.valueOf(request.getParameter("memberid"));
		String title=request.getParameter("title");
		String qaContent=request.getParameter("qacontent");
		HalaBean ha= new HalaBean();
		try {
		QaInterface hd=new QaService(session);
		hd.insertQa(qaClassName,memberId,title,qaContent);
		request.setAttribute("qa", hd);
		RequestDispatcher rd=request.getRequestDispatcher("/QaCrudServlet");
		rd.forward(request, response);
		return;
		}catch (Exception e ) {
			e.printStackTrace();
		}
	}
}
	