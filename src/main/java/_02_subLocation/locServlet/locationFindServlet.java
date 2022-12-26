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

import  _02_subLocation.bean.locationclass;
import  _02_subLocation.dao.locationdao;


@WebServlet("/locServlet/locationFindServlet")
public class locationFindServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

 private static Logger log = LoggerFactory.getLogger(locationFindServlet.class);
 
 int pageNo = 1;

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  doPost(request, response);
 }

  

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  
 
	 locationdao classService = new locationdao();
	try {
		request.setCharacterEncoding("UTF-8");
		String locclass = request.getParameter("locclass"); //讀取瀏覽器送來的資料
        if (locclass == null || locclass.trim().length() == 0 ) {
        	locclass = "";   // 如果讀不到使用者輸入的資料，將變數設為""; 
        	RequestDispatcher rd = request.getRequestDispatcher("/locServlet/locationSearch");
        	rd.forward(request, response);
        }else {
		List<locationclass> classList = classService.findByClass(locclass);
		request.setAttribute("classList",classList);
		RequestDispatcher rd = request.getRequestDispatcher("/html/location/locRead.jsp");
		rd.forward(request, response);
        }
		return;
	} catch(UnsupportedEncodingException e) {
        throw new ServletException(e); 
     } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	



 }
}
