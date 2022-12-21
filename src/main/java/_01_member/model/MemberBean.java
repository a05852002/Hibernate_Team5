package _01_member.model;

import java.io.Serializable;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Member")
public class MemberBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberID")
	private int memberID;
	
	@Column(name = "account")
	private String account = "";
		
	@Column(name = "password")
	private String password = "";
		
	@Column(name = "idnumber")
	private String idNumber = "";
		
	@Column(name = "memname")
	private String memName = "";
		
	@Column(name = "memnickname")
	private String memNickName = "";
		
	@Column(name = "memold")
	private int memOld;
		
	@Column(name = "membirth")
	private String memBirth  = "";
	
	@Column(name = "memgender")
	private String memGender = "";
		
	@Column(name = "email")
	private String eMail = "";
		
	@Column(name = "phone")
	private int phone;
		
	@Column(name = "photo")
	private Blob photo;
		
	@Column(name = "address")
	private String address = "";
		
	@Column(name = "registime")
	private String registime = "";
	
	public MemberBean() {
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemNickName() {
		return memNickName;
	}

	public void setMemNickName(String memNickName) {
		this.memNickName = memNickName;
	}

	public int getMemOld() {
		return memOld;
	}

	public void setMemOld(int memOld) {
		this.memOld = memOld;
	}

	public String getMemBirth() {
		return memBirth;
	}

	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}

	public String getMemGender() {
		return memGender;
	}

	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegistime() {
		return registime;
	}

	public void setRegistime() {
		this.registime = new SimpleDateFormat("YYYY/MM/DD").format(new Date());
	}

	@Override
	public String toString() {
		return "MemberBean [memberID=" + memberID + ", account=" + account + ", password=" + password + ", idNumber="
				+ idNumber + ", memName=" + memName + ", memNickName=" + memNickName + ", memOld=" + memOld
				+ ", memBirth=" + memBirth + ", memGender=" + memGender + ", eMail=" + eMail + ", phone=" + phone
				+ ", photo=" + photo + ", address=" + address + ", registime=" + registime + "]";
	}

}
