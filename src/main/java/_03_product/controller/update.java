package _03_product.controller;

import java.io.IOException;


import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import _03_product.model.ProdDaoService;

@MultipartConfig()
@WebServlet("/produpdate")
public class update extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		int oldProdClass = Integer.valueOf(req.getParameter("oldProdClass"));
		System.out.println(oldProdClass);
		int NewPclass = Integer.valueOf(req.getParameter("prodClass"));
		System.out.println(NewPclass);
		int prodID = Integer.valueOf(req.getParameter("prodID"));
		String pName = req.getParameter("prodName");
		int pPrice = Integer.valueOf(req.getParameter("prodPrice"));
		int memID = Integer.valueOf(req.getParameter("memberID"));
		int invt = Integer.valueOf(req.getParameter("inventory"));
		InputStream in = req.getPart("images").getInputStream();
		long size = req.getPart("images").getSize();
		
		Blob image = null;
		try {
			image = ProdGlobalService.fileToBlob(in, size);
			ProdDaoService pDao = new ProdDaoService();
			if (req.getPart("images").getSize() != 0) {
				pDao.updateProdWithPhotoFromProdID(oldProdClass,NewPclass, pName, pPrice, memID, invt, image, prodID);
			}else {
				pDao.updateProdWithoutPhotoFromProdID(oldProdClass,NewPclass, pName, pPrice, memID, invt, prodID);
			}
			
			resp.sendRedirect(req.getContextPath() + "/web/searchingProd");

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
