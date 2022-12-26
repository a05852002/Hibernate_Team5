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
import _05_teacStu.service.teacAndStudService;
import _05_teacStu.service.teacAndStudServiceInterface;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_05_teacStu/searchAllStudServlet")
public class searchAllStudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public searchAllStudServlet() {
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		   throws ServletException, IOException {
    		  doPost(request, response);
    		 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
		
			teacAndStudServiceInterface tsDao = new teacAndStudService(session);
			List<tableForStud> stud = tsDao.searchAllStud();
			
			request.setAttribute("classList", stud);
			RequestDispatcher rd = request.getRequestDispatcher("/html/_05_teacStu/studCRUD.jsp");
			rd.forward(request, response);
	}
}
