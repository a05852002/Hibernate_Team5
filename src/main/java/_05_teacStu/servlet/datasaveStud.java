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

import _05_teacStu.model.tableForStud;
import _05_teacStu.service.teacAndStudService;
import _05_teacStu.service.teacAndStudServiceInterface;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_05_teacStu/datasaveStud")
public class datasaveStud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int studno = 0;
		String strclassId = request.getParameter("studno");
		studno = Integer.parseInt(strclassId);
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		teacAndStudServiceInterface classDao = new teacAndStudService(session);

		tableForStud bean = classDao.searchStudFromStudno(studno);
		request.setAttribute("bean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("/html/_05_teacStu/updatestud.jsp");
		rd.forward(request, response);
		return;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
