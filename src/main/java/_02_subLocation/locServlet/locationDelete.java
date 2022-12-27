package  _02_subLocation.locServlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import  _02_subLocation.dao.locationdao;


@WebServlet("/locServlet/locationDelete.do")
public class locationDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(locationDelete.class);
	int pageNo = 1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		locationdao classService = new locationdao();
		 int locNo = Integer.valueOf( request.getParameter("locNo"));
			try {
				classService.deleteLocfromLocno(locNo);
				RequestDispatcher rd = request.getRequestDispatcher("/locServlet/locationSearch");
				rd.forward(request, response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
