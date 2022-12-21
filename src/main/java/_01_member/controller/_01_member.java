package _01_member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _01_member.model.MemberBean;
import _01_member.model.MemberDao;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/_01_member.do")
public class _01_member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doget(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		設定編碼
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
//      建立error message Map
        HashMap<String, String> errorMsgMap = new HashMap<String,String>();
//      建立請求列表
        Map<String, String[]> orders = request.getParameterMap();
//      建立資料庫連線
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
//      建立model物件
        MemberDao md = new MemberDao(session);
        
        if (orders.containsKey("selectAll")){
        	List<MemberBean> list = null ;
        	RequestDispatcher rd;
			
			try {
				session.beginTransaction();
				list = md.searchAllMember();
				session.getTransaction().commit();
				
			} catch (Exception e) {
				System.out.println("有問題");
				session.getTransaction().rollback();
				e.printStackTrace();
			}
			
			request.setAttribute("Member", list);
			rd = request.getRequestDispatcher("../_01_member/admin.jsp");
			rd.forward(request, response);
			
        }
        
        
        
        
        
        
        
        
        
        
	}

}
