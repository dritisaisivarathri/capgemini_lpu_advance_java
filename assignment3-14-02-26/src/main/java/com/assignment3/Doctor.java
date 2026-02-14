package com.assignment3;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	@Id
	private int doctorId;
	private String doctorName;
	private String doctorSpecialization;
	
	@OneToMany
	private List<Appointment> appointments;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorSpecialization="
				+ doctorSpecialization + "]";
	}
	public List<Appointment> getAppointment() {
		return appointments;
	}
	public void setAppointment(List<Appointment> appointment, List<Appointment> appointments) {
		this.appointments = appointments;
	}
	public void setAppointments(List<Appointment> asList) {
		// TODO Auto-generated method stub
		
	}
	
	

}
