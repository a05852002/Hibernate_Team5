package _02_subLocation.locServlet;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import  _02_subLocation.dao.locationdao;


@WebServlet("/locServlet/locationCreateServlet")
public class locationCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(locationCreateServlet.class);

	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int locNo = Integer.valueOf(request.getParameter("locno"));
		String locName = request.getParameter("locname");
		String locClass = request.getParameter("locclass");
//		subjectclass subject = new subjectclass();
//		subject.setSubno(subNo);
//		subject.setSubname(subName);
//		subject.setSubclass(subClass);
		try {
			locationdao classService = new locationdao();
			classService.add(locNo,locName,locClass);
			request.setAttribute("classService", classService);
			RequestDispatcher rd = request.getRequestDispatcher("/locServlet/locationSearch");
			rd.forward(request, response);
			return;

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
