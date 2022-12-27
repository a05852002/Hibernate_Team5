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

import _02_subLocation. bean.locationclass;
import  _02_subLocation.bean.subjectclass;
import  _02_subLocation.dao.locationdao;
import  _02_subLocation.dao.subjectdao;

@WebServlet("/locServlet/locationSearch")
public class locationSearch extends HttpServlet {
private static final long serialVersionUID = 1L;

 private static Logger log = LoggerFactory.getLogger(locationSearch.class);
 
 int pageNo = 1;

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  doPost(request, response);
 }

  

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  
 
	 locationdao classService = new locationdao(); 
	try {
		
		List<locationclass> classlist = classService.searchAllLoc();
		request.setAttribute("classList",classlist);
		RequestDispatcher rd = request.getRequestDispatcher("/html/location/locCRUD.jsp");
		rd.forward(request, response);
		return;
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	

 }
}
                                                                                                                                                                                                                                                                                                                                  