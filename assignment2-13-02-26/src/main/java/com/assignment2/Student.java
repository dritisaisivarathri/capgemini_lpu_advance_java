package com.assignment2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int stuId;
	private String stuName;
	private String stuEmail;
	private String stuBranch;
	
	@OneToOne
	private AadharCard aadharCard;
	
	@OneToOne
	private HostelRoom hostelRoom;
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getStuBranch() {
		return stuBranch;
	}
	public void setStuBranch(String stuBranch) {
		this.stuBranch = stuBranch;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuEmail=" + stuEmail + ", stuBranch="
				+ stuBranch + "]";
	}
	public AadharCard getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(AadharCard aadharCard) {
		this.aadharCard = aadharCard;
	}
	public HostelRoom getHostelRoom() {
		return hostelRoom;
	}
	public void setHostelRoom(HostelRoom hostelRoom) {
		this.hostelRoom = hostelRoom;
	}
	
	
	

}
