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
@MultipartConfig
@WebServlet("/_03_product/addNewProductServlet")
public class AddNewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewProductServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("AddNewProductServlet:");
		int pclass = Integer.valueOf(req.getParameter("pClass"));
		String pName = req.getParameter("pName");
		int pPrice = Integer.valueOf(req.getParameter("pPrice"));
		int memID = Integer.valueOf(req.getParameter("memID"));
		int invt = Integer.valueOf(req.getParameter("invt"));
		InputStream in = req.getPart("pPic").getInputStream();
		long size = req.getPart("pPic").getSize();

		Blob image = null;
		try {
			image = ProdGlobalService.fileToBlob(in, size);
		} catch (IOException e) {
			System.out.println("addServlet-IOException");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("addServlet-SQLException");
			e.printStackTrace();
		}

		System.out.println("AddNewProductServlet:before addDao");
		ProdDaoService pDao = new ProdDaoService();
		pDao.addNewProduct(pclass, pName, pPrice, memID, invt, image);
		System.out.println("AddNewProductServlet:after addDao");

		resp.sendRedirect(req.getContextPath() + "/web/searchingProd");

	}

}
