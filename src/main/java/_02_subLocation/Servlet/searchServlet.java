package _02_subLocation.Servlet;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _02_subLocation.dao.SubjectDao;
import _02_subLocation.dao.impl.SubjectDaoImpl;
import _02_subLocation.model.SubjectBean;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/Servlet/searchServlet.do")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(searchServlet.class);
	int pageNo = 1;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");  
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		SubjectDao classService = new SubjectDaoImpl(session);
		  int sNo = Integer.valueOf( request.getParameter("subNo"));
			List<SubjectBean> classlist = classService.findById(sNo);
			request.setAttribute("classList",classlist);
			RequestDispatcher rd = request.getRequestDispatcher("/html/_02_subLocation/subject/subUpdate.jsp");
			rd.forward(request, response);
			return;
	}

}
