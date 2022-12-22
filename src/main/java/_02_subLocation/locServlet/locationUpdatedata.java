package _02_subLocation.locServlet;

import java.io.IOException;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import  _02_subLocation.dao.locationdao;




@MultipartConfig()
@WebServlet("/locServlet/locationUpdatedata")
public class locationUpdatedata extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}
	
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("utf-8");
	 response.setCharacterEncoding("utf-8");
	 locationdao classService = new locationdao();
	System.out.println(request.getParameter("locNo"));
	int locNo = Integer.parseInt(request.getParameter("locNo"));
	String locName = request.getParameter("locName");
	String locClass = request.getParameter("locClass");
    try {
    	classService.updateLocFromLocno(locNo, locName, locClass);
		RequestDispatcher rd = request.getRequestDispatcher("/locServlet/locationSearch");
		rd.forward(request, response);
		return;
  
  } catch (IOException | SQLException e) {
   e.printStackTrace();
  }
  
  
  
  
 }


}
