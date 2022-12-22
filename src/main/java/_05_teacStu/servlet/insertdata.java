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

import _05_teacStu.model.tableForTeac;
import _05_teacStu.model.teacAndStudDao;
import _05_teacStu.service.GlobalService;
import tw.hibernatedemo.util.HibernateUtil;

@MultipartConfig()
@WebServlet("/_05_teacStu/insertdata")
public class insertdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer memberId = Integer.parseInt(req.getParameter("memberId"));
		String title = req.getParameter("title");
		String detail = req.getParameter("detail");
		Double price = Double.valueOf(req.getParameter("price"));
		String subjectItem = req.getParameter("subjectItem");
		InputStream in = req.getPart("images").getInputStream();
		long size = req.getPart("images").getSize();
		try {
			Blob image = GlobalService.fileToBlob(in, size);
			Date date = new Date();
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.getCurrentSession();
			teacAndStudDao tDao = new teacAndStudDao(session);
			tableForTeac t = new tableForTeac();
			t.setMemberId(memberId);
			t.setTitle(title);
			t.setPostDate(date);
			t.setDetail(detail);
			t.setPrice(price);
			t.setSubjectItem(subjectItem);
			t.setClassPicture(image);

			tDao.addTeac(t);
			resp.sendRedirect(req.getContextPath() + "/_05_teacStu/searchAllTeacServlet");

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
