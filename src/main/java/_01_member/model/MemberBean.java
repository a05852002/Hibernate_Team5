package _01_member.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Member")
public class MemberBean {

	private int memberID;
	private String account = "";
	private String password = "";
	private String idNumber = "";
	private String memName = "";
	private String memNickName = "";
	private int memOld;
	private String memBirth  = "";
	private String memGender = "";
	private String eMail = "";
	private int phone;
	private Blob photo;
	private String address = "";
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

	public void setRegistime(String registime) {
		this.registime = registime;
	}

	@Override
	public String toString() {
		return "MemberBean [memberID=" + memberID + ", account=" + account + ", password=" + password + ", idNumber="
				+ idNumber + ", memName=" + memName + ", memNickName=" + memNickName + ", memOld=" + memOld
				+ ", memBirth=" + memBirth + ", memGender=" + memGender + ", eMail=" + eMail + ", phone=" + phone
				+ ", photo=" + photo + ", address=" + address + ", registime=" + registime + "]";
	}

}
