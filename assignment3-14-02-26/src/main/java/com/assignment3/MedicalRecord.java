package com.assignment3;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MedicalRecord {
	@Id
	private int medicalId;
	private String medicalBloodGroup;
	private String medicalAllergies;
	public int getMedicalId() {
		return medicalId;
	}
	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}
	public String getMedicalBloodGroup() {
		return medicalBloodGroup;
	}
	public void setMedicalBloodGroup(String medicalBloodGroup) {
		this.medicalBloodGroup = medicalBloodGroup;
	}
	public String getMedicalAllergies() {
		return medicalAllergies;
	}
	public void setMedicalAllergies(String medicalAllergies) {
		this.medicalAllergies = medicalAllergies;
	}
	@Override
	public String toString() {
		return "MedicalRecord [medicalId=" + medicalId + ", medicalBloodGroup=" + medicalBloodGroup
				+ ", medicalAllergies=" + medicalAllergies + "]";
	}
	

}
