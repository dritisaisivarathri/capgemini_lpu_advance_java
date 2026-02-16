package com.manyToOneMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "number_sequence")
	@SequenceGenerator(name="number_sequence",sequenceName = "number_sequence",initialValue = 100,allocationSize = 1)
	private int deptId;
	private String deptName;
	private String managerName;
	private int numOfEmp;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getNumOfEmp() {
		return numOfEmp;
	}
	public void setNumOfEmp(int numOfEmp) {
		this.numOfEmp = numOfEmp;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", managerName=" + managerName
				+ ", numOfEmp=" + numOfEmp + "]";
	}
	

}
