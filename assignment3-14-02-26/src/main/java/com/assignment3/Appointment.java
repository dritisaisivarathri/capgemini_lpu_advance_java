package com.assignment3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	private int appointmentId;
	private String appointmentVisitDate;
	private int appointmentFee;
	
	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Doctor doctor;
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getAppointmentVisitDate() {
		return appointmentVisitDate;
	}
	public void setAppointmentVisitDate(String appointmentVisitDate) {
		this.appointmentVisitDate = appointmentVisitDate;
	}
	public int getAppointmentFee() {
		return appointmentFee;
	}
	public void setAppointmentFee(int appointmentFee) {
		this.appointmentFee = appointmentFee;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentVisitDate=" + appointmentVisitDate
				+ ", appointmentFee=" + appointmentFee + "]";
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public void setFee(double newFee) {
		this.appointmentFee = (int) newFee;
	}
	
	
	

}
