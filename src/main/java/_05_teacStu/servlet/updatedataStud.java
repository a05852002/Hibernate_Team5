package _05_teacStu.servlet;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _05_teacStu.model.teacAndStudDao;
import _05_teacStu.service.GlobalService;
import tw.hibernatedemo.util.HibernateUtil;

@MultipartConfig()
@WebServlet("/_05_teacStu/updatedataStud")
public class updatedataStud extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer teacno = Integer.valueOf(req.getParameter("teacno"));
		Integer memberId = Integer.parseInt(req.getParameter("memberId"));
		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		Double price = Double.valueOf(req.getParameter("price"));
		String subjectItem = req.getParameter("subjectItem");
		String learnLoc = req.getParameter("learnLoc");
		InputStream in = req.getPart("images").getInputStream();
		long size = req.getPart("images").getSize();
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Blob image = GlobalService.fileToBlob(in, size);
			Date date = new Date();

			teacAndStudDao tsDao = new teacAndStudDao(session);
			tsDao.updateStudFromStudno(teacno, memberId, title, date, detail, price, subjectItem, learnLoc, image);
			resp.sendRedirect(req.getContextPath() + "/_05_teacStu/searchAllStudServlet");

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
