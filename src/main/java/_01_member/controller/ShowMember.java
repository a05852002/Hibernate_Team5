package _01_member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _01_member.model.MemberDao;
import _01_member.util.HibernateUtil;

/**
 * Servlet implementation class ShowMember
 */
@WebServlet("/_01_member/ShowMember.do")
public class ShowMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MemberDao md = new MemberDao(session);
		String account = request.getParameter("id");
		Blob blob = null;
		InputStream is = null;
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		try {
			session.beginTransaction();
			blob = md.ShowPhoto(account);
			System.out.println(blob);
			is = blob.getBinaryStream();
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}
			session.getTransaction().commit();
		} catch (SQLException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			   if (is != null) is.close();
			   if (os != null) os.close();
			  }

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
