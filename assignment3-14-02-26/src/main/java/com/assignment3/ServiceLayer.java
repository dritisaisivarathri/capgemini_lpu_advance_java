package com.assignment3;

import java.util.List;

public class ServiceLayer {

    private PatientDao patientDao = new PatientDao();
    private DoctorDao doctorDao = new DoctorDao();
    private AppointmentDao appointmentDao = new AppointmentDao();

    // ------------------------------------------------
    // 1️⃣ Register patient with medical record
    // ------------------------------------------------
    public String registerPatientWithMedicalRecord(Patient patient,
                                                   MedicalRecord record) {

        if (patient == null || record == null) {
            return "Invalid data";
        }

        // set relationship
        patient.setMedicalRecord(record);

        return patientDao.insert(patient);
    }


    // ------------------------------------------------
    // 2️⃣ Add multiple appointments to doctor
    // ------------------------------------------------
    public String addAppointmentsToDoctor(int doctorId,
                                          List<Appointment> appointments) {

        Doctor doctor = doctorDao.find(doctorId);

        if (doctor == null) {
            return "Doctor not found";
        }

        for (Appointment a : appointments) {
            a.setDoctor(doctor);
            appointmentDao.insert(a);
        }

        return "Appointments added to doctor";
    }


    // ------------------------------------------------
    // 3️⃣ Assign appointment to patient
    // ------------------------------------------------
    public String assignAppointmentToPatient(int appointmentId,
                                             int patientId) {

        Patient patient = patientDao.find(patientId);
        Appointment appointment =
                appointmentDao.findById(appointmentId);

        if (patient == null || appointment == null) {
            return "Invalid patient or appointment";
        }

        appointment.setPatient(patient);
        appointmentDao.updateAppointment(appointment);

        return "Appointment assigned to patient";
    }


    // ------------------------------------------------
    // 4️⃣ Update appointment fee
    // ------------------------------------------------
    public String updateAppointmentFee(int appointmentId,
                                       double newFee) {

        return appointmentDao.updateFee(appointmentId, newFee);
    }


    // ------------------------------------------------
    // 5️⃣ Fetch doctor with appointments
    // ------------------------------------------------
    public Doctor fetchDoctorWithAppointments(int doctorId) {

        Doctor doctor = doctorDao.find(doctorId);

        if (doctor == null) {
            System.out.println("Doctor not found");
            return null;
        }

        // Print appointments
        if (doctor.getAppointments() != null) {
            doctor.getAppointments()
                  .forEach(a -> System.out.println(a));
        }

        return doctor;
    }


    // ------------------------------------------------
    // 6️⃣ Delete patient and verify behavior
    // ------------------------------------------------
    public String deletePatient(int patientId) {

        String result = patientDao.delete(patientId);

        // Verification step
        Patient check = patientDao.find(patientId);

        if (check == null) {
            System.out.println("Patient successfully deleted");
        }

        return result;
    }
}
