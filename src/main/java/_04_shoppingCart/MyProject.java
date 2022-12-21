package _04_shoppingCart;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;

import _04_ShoppingCart.dao.OrdersDao;
import _04_ShoppingCart.dao.OrdersItemDao;
import factory.dbfactory;

public class MyProject {

	public static void main(String[] args) throws SQLException {

		QueryRunner queryRunner = new QueryRunner(dbfactory.createMSSQLConnection());
		OrdersDao OrdersDao = new OrdersDao();
//		Date dt = new Date();
//		OrdersDao.insert("AAASSD", "台中");
		
//		OrdersDao.updateOrderFromOrderNo(1, "456458", dt, "vuip", 800.0);
//		OrdersDao.searchAllLike("AB");
//		OrdersDao.deleteOrderNo(1);
//		OrdersDao.updateOrderFromOrderNo(1,"3345687",dt, "聖德", 200.0);
//		OrdersDao.searchOrderNoLike(6);
		
		OrdersItemDao ordersItemDao = new OrdersItemDao();
		ordersItemDao.insertItem(2,"BBAA","水", "很棒的產品", 2,100.0);
//		ordersItemDao.searchOrderItemByOrderNo(1);
//		ordersItemDao.deleteOrderItemNo(1,2);
//		ordersItemDao.searchSeqnoByOrderNo(1);

	}

}
