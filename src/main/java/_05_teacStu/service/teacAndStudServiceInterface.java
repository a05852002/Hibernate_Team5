package _05_teacStu.service;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import _05_teacStu.model.tableForStud;
import _05_teacStu.model.tableForTeac;

public interface teacAndStudServiceInterface {
//	模糊查詢教師全部
	public List<tableForTeac> searchAllLike(String searchAllLike);
	
//	模糊查詢學生全部
	public List<tableForStud> searchAllLikeStud(String searchAllLike);
	
//  透過時薪區間建立教師貼文查詢
	public List<tableForTeac> searchTeacByPrice(Integer low, Integer high);
	
//  透過時薪區間建立學生貼文查詢
	public List<tableForStud> searchStudByPrice(Integer low, Integer high);
	
//	搜尋全部教師貼文依時薪降序排序
	public List<tableForTeac> searchAllTeacOBprice();
	
//	搜尋全部學生貼文依時薪降序排序
	public List<tableForStud> searchAllStudOBprice();
	
//	搜尋全部教師貼文依日期降序排序
	public List<tableForTeac> searchAllTeacOBpDate();
	
//	搜尋全部學生貼文依日期降序排序
	public List<tableForStud> searchAllStudOBpDate();
	
//	搜尋全部教師貼文依會員編號排序
	public List<tableForTeac> searchAllTeacOBmId();
	
//	搜尋全部學生貼文依會員編號排序
	public List<tableForStud> searchAllStudOBmId();
	
//	透過貼文編號建立教師貼文查詢
	public tableForTeac searchTeacFromTeacno(Integer teacno);
	
//	透過貼文編號建立學生貼文查詢
	public tableForStud searchStudFromStudno(Integer studno);
	
//	搜尋全部教師貼文
	public List<tableForTeac> searchAllTeac();
	
//	搜尋全部學生貼文
	public List<tableForStud> searchAllStud();
	
//	新增教師貼文
	public void addTeac(tableForTeac tableForTeac);
	
//	新增學生貼文
	public void addStud(tableForStud tableForStud);
	
//	透過ID刪除教師貼文
	public void deleteTeacfromTeacno(Integer teacno);
	
//	透過ID刪除學生貼文
	public void deleteStudfromStudno(Integer studno);
	
//	透過ID修改教師貼文
	public tableForTeac updateTeacFromTeacno(Integer teacno, Integer memberId, String title, Date postDate,
			String detail, Double price, String subjectItem, Blob ClassPicture);
	
//	透過ID修改學生貼文
	public tableForStud updateStudFromStudno(Integer studno, Integer memberId, String title, Date postDate,
			String detail, Double price, String subjectItem, String learnLoc, Blob ClassPicture);
}
