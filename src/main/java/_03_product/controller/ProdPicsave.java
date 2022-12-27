package _03_product.controller;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _03_product.model.ProdDaoService;
import _03_product.model.Product;
import _03_product.model.ProdDao;
import tw.hibernatedemo.util.HibernateUtil;

@WebServlet("/Servlet/prodpicsave")
public class ProdPicsave extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(ProdPicsave.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		OutputStream os = null;
		InputStream is = null;
		Blob blob = null;
		try {
			// 讀取瀏覽器傳送來的主鍵
			String id = request.getParameter("id");
			// 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
			ProdDaoService pDao = new ProdDaoService();
			int pId = 0;
			pId = Integer.parseInt(id);

			Product prod = pDao.searchSingleProductFromProdID(pId);
			if (prod != null) {
				blob = prod.getProdImg();
				if (blob != null) {
					is = blob.getBinaryStream();
				}
			}
			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)

			// 設定輸出資料的MIME型態
			response.setContentType("jpg/png");
			// 取得能寫出非文字資料的OutputStream物件
			os = response.getOutputStream();
			// 由InputStream讀取位元組，然後由OutputStream寫出
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}
			log.info("送出Book圖片, id=" + 6);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (is != null)
				is.close();
			if (os != null)
				os.close();
		}
	}
}
