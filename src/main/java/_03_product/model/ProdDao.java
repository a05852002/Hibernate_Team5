package _03_product.model;

import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class ProdDao {

	private Session session;

	public ProdDao(Session session) {
		this.session = session;
	}

	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return sdf.format(date);
	}

//	shoppingHome 全部搜尋
	public List<Product> searchAllProduct() throws SQLException {
		Query<Product> query = session.createQuery("from Product", Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

//	給ProdPicSave使用 來找尋單一的Product 並顯示圖片
//	或是 單純用來搜尋單一Product
	public Product searchSingleProductFromProdID(Integer prodID) throws SQLException {
//		System.out.println("DaoSingleSearch-0");
		Product prod = session.get(Product.class, prodID);
//		System.out.println("DaoSingleSearch-1");
		return prod;
	}

//	新增一項商品資訊
	public void addNewProduct(int prodClass, String prodName, int prodPrice, int memberID, int inventory,
			Blob prodImg) {

		ProdType currentProdType = session.get(ProdType.class, prodClass);
		Product newProd = new Product();

		newProd.setProdName(prodName);
		newProd.setProdPrice(prodPrice);
		newProd.setMemberID(memberID);
		newProd.setInventory(inventory);
		newProd.setProdPost(getCurrentDate());
		newProd.setProdUpdate(getCurrentDate());
		newProd.setProdImg(prodImg);
		newProd.setProdtype(currentProdType);

		LinkedHashSet<Product> prods = new LinkedHashSet<Product>();
		prods.add(newProd);
		currentProdType.setProduct(prods);

		session.save(currentProdType);
//		System.out.println("testProdClass="+newProd.getProdClass());
	}

//	透過prodID刪除整筆資料
	public void deleteProdFromProdID(Integer prodID) {
//		System.out.println("DaoDeleteProd-1");
		Product prod = session.get(Product.class, prodID);
//		System.out.println("DaoDeleteProd-2");
		if (prod != null) {
//			System.out.println("DaoDeleteProd-3");
			session.remove(prod);
		}
	}

//	透過prodID修改product的資料 -- update including photo as well 含照片
	public void updateProdWithPhotoFromProdID(int oldProdClass, int NewProdClass, String prodName, int prodPrice,
			int memberID, int inventory, Blob prodImg, int prodID) {

		ProdType NewProdType = session.get(ProdType.class, NewProdClass);
		Product prod = session.get(Product.class, prodID);

			prod.setProdName(prodName);
			prod.setProdPrice(prodPrice);
			prod.setMemberID(memberID);
			prod.setInventory(inventory);
			prod.setProdUpdate(getCurrentDate());
			prod.setProdImg(prodImg);
			prod.setProdtype(NewProdType);

	}

//	透過prodID修改product的資料 -- update without updating photo 不含照片
	public void updateProdWithoutPhotoFromProdID(int oldProdClass, int NewProdClass, String prodName, int prodPrice,
			int memberID, int inventory, int prodID) {
		
		ProdType NewProdType = session.get(ProdType.class, NewProdClass);
		Product prod = session.get(Product.class, prodID);

			prod.setProdtype(NewProdType);
			prod.setProdName(prodName);
			prod.setProdPrice(prodPrice);
			prod.setMemberID(memberID);
			prod.setInventory(inventory);
			prod.setProdUpdate(getCurrentDate());

		
	}

//	幹你娘這三小搜尋
	public List<Product> searchShit(String type, Integer low, Integer high, String name, Integer order)
			throws SQLException {

//		where
		boolean lowisNull = (low == 0);
		boolean highisNull = (high == 999999);
		boolean typeisNull = (type.equals("*"));
		boolean nameisNull = (name == null);
		
		String where = " where ";
		if (lowisNull) {
			if (highisNull) {
				if (typeisNull) {
					if (nameisNull) {
						where = "";
					}
				}
			}
		}

//		price
		boolean wroungside = (low > high);
		String price = "";
		if (lowisNull && highisNull) {
			price = "";
		} else if (wroungside) {
			price = "";
		} else if (lowisNull) {
			price = "prodprice <= " + high + " ";
		} else if (highisNull) {
			price = "prodprice >= " + low + " ";
		} else if (!(highisNull && lowisNull)) {
			price = "prodPrice >= " + low + " and prodPrice <= " + high + " ";
		}
//		type
		String and = "and";
		if (price.equals("")||typeisNull) {
			and = "";
		}
		String typeOf = "";
		if (type.equals("*")) {
			typeOf = "";
		} else if (type.equals("1")) {
			typeOf = " prodclass = " + type + " ";
		} else if (type.equals("2")) {
			typeOf = " prodclass = " + type + " ";
		} else if (type.equals("3")) {
			typeOf = " prodclass = " + type + " ";
		}

//		name %%%%
		String and2 = " and ";
		if (lowisNull && highisNull) {
			if (typeisNull) {
				and2 = "";
			}
		}

		if (nameisNull) {
			and2 = "";
		}

		String sqlnamelike = "";
		String querynamelike = "";
		if (!nameisNull) {
			sqlnamelike = " prodName like  ";
			querynamelike = "%" + name + "%";
		}

//		order by
		String orderBy = "";
		if (order == 1) {
			orderBy = " order by prodID";
		} else if (order == 2) {
			orderBy = " order by prodPrice DESC";
		} else if (order == 3) {
			orderBy = " order by prodPrice";
		} else if (order == 4) {
			orderBy = " order by prodPost DESC";
		} else if (order == 5) {
			orderBy = " order by prodUpdate DESC";
		}
		
		if(nameisNull) {
			String hql = "from Product" + where + price + and + typeOf + orderBy;
			Query<Product> query= session.createQuery(hql,Product.class);
			List<Product> list = query.getResultList();
			return list;
		}else {
			String hql = "from Product" + where + price + and + typeOf + and2 + " prodName like :n "+ orderBy;
			Query<Product> query= session.createQuery(hql,Product.class).setParameter("n", "%"+name+"%");
			List<Product> list = query.getResultList();
			return list;
		}

		

	}


}
