package _01_member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import _01_member.model.MemberBean;
import _01_member.model.MemberDao;
import _01_member.util.HibernateUtil;

@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/_01_member/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//進行編碼
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				// 準備存放錯誤訊息的Map物件(requestScope)
				Map<String, String> requestErrorMsg = new HashMap<String, String>();
				// 準備存放註冊成功之訊息的Map物件(sessionScope)
				Map<String, String> sessionMessageOK = new HashMap<String, String>();
				// 註冊成功後將用response.sendRedirect(newURL)導向新的畫面，所以需要以
				// HttpSession物件來存放共用資料。
				HttpSession httpSession = request.getSession();
				request.setAttribute("MsgMap", requestErrorMsg); // 顯示錯誤訊息
				httpSession .setAttribute("MsgOK", sessionMessageOK); // 顯示正常訊息
//				String account = "";
//				String password = "";
//				String idNumber = "";
//				String memName = "";
//				String memNickName = "";
//				int memOld = 0;
//				String memBirth  = "";
//				String memGender = "";
//				String email = "";
//				int phone = 0;
//				String address = "";
				String fileName ="";
				long sizeInBytes = 0;				
				InputStream is = null;
				MemberBean member = new MemberBean();
				
				Collection<Part> parts = request.getParts();
				for (Part p : parts) {
					//foreach資料提取
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					
					//判斷並放入各對應值內處理
					if (p.getContentType() == null) {
						if (fldName.equals("account")) {
							member.setAccount(value);
						} else if (fldName.equals("password")) {
							member.setPassword(value);
						} else if (fldName.equals("idNumber")) {
							member.setIdNumber(value);
						} else if (fldName.equals("memName")) {
							member.setMemName(value);
						} else if (fldName.equals("memNickName")) {
							member.setMemNickName(value);
						} else if (fldName.equals("memOld")) {
							member.setMemOld(Integer.parseInt(value));
						} else if (fldName.equals("memBirth")) {
							member.setMemBirth(value);
						} else if (fldName.equals("memGender")) {
							member.setMemGender(value);
						} else if (fldName.equals("email")) {
							member.seteMail(value);
						} else if (fldName.equals("phone")) {
							member.setPhone(Integer.parseInt(value));
						} else if (fldName.equals("address")) {
							member.setAddress(value);
						}
					} else {
						// 取出圖片檔的檔名
						fileName = ImgService.getFileName(p);
						// 調整圖片檔檔名的長度，需要檔名中的附檔名，所以調整主檔名以免檔名太長無法寫入表格
						fileName = ImgService.adjustFileName(fileName, ImgService.IMAGE_FILENAME_LENGTH);
						if (fileName != null && fileName.trim().length() > 0) {
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						} 
					}
				}
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.getCurrentSession();
				MemberDao md = new MemberDao(session);
				//資料更新
				try {
					session.beginTransaction();
					md.updateMemFromAccount(member);
					if (fileName != null && fileName.trim().length() > 0) {
						md.updatePhotoFromAccount(member.getAccount(), is);
					}
					List<MemberBean> list = md.searchAllMember();
					request.setAttribute("Member", list);
					RequestDispatcher rd = request.getRequestDispatcher("/html/_01_member/admin.jsp");
					rd.forward(request, response);
					session.getTransaction().commit();
				} catch (Exception e) {
					session.getTransaction().rollback();
					e.printStackTrace();
				}
				
	}

}
