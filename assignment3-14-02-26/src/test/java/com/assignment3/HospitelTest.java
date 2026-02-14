package com.assignment3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HospitalTest {

    private static PatientDao patientDao;
    private static DoctorDao doctorDao;
    private static AppointmentDao appointmentDao;
    private static ServiceLayer service;

    @BeforeAll
    static void setup() {
        patientDao = new PatientDao();
        doctorDao = new DoctorDao();
        appointmentDao = new AppointmentDao();
        service = new ServiceLayer();
    }

    // --------------------------------------------------
    // 1️⃣ OneToOne Persist Test
    // --------------------------------------------------
    @Test
    void testOneToOnePersist() {

        Patient patient = new Patient();
        patient.setPatientId(1);
        patient.setPatientName("Driti");
        patient.setPatientAge(22);
        patient.setPatientContact("9999999999");

        MedicalRecord record = new MedicalRecord();
        record.setMedicalId(101);
        record.setMedicalBloodGroup("O+");
        record.setMedicalAllergies("None");

        patient.setMedicalRecord(record);

        String result = patientDao.insert(patient);

        assertEquals("Patient Data saved", result);
        assertNotNull(patientDao.find(1));
    }


    // --------------------------------------------------
    // 2️⃣ OneToMany Persist Test (Doctor → Appointments)
    // --------------------------------------------------
    @Test
    void testOneToManyPersist() {

        Doctor doctor = new Doctor();
        doctor.setDoctorId(1);
        doctor.setDoctorName("Dr. Rao");
        doctor.setDoctorSpecialization("Cardiology");

        Appointment a1 = new Appointment();
        a1.setAppointmentId(11);
        a1.setAppointmentVisitDate("2026-02-14");
        a1.setAppointmentFee(500);
        a1.setDoctor(doctor);

        Appointment a2 = new Appointment();
        a2.setAppointmentId(12);
        a2.setAppointmentVisitDate("2026-02-15");
        a2.setAppointmentFee(600);
        a2.setDoctor(doctor);

        doctor.setAppointments(Arrays.asList(a1, a2));

        doctorDao.insert(doctor);

        assertNotNull(doctorDao.find(1));
    }


    // --------------------------------------------------
    // 3️⃣ ManyToOne Persist Test (Appointment → Doctor)
    // --------------------------------------------------
    @Test
    void testManyToOnePersist() {

        Doctor doctor = doctorDao.find(1);

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(20);
        appointment.setAppointmentVisitDate("2026-02-20");
        appointment.setAppointmentFee(700);
        appointment.setDoctor(doctor);

        String result = appointmentDao.insert(appointment);

        assertEquals("Appointment Data saved", result);
    }


    // --------------------------------------------------
    // 4️⃣ DAO Update Test
    // --------------------------------------------------
    @Test
    void testUpdateFee() {

        String result = appointmentDao.updateFee(20, 1000);

        assertEquals("Fee updated successfully", result);

        Appointment updated = appointmentDao.findById(20);
        assertEquals(1000, updated.getAppointmentFee());
    }


    // --------------------------------------------------
    // 5️⃣ DAO Delete Test
    // --------------------------------------------------
    @Test
    void testDeletePatient() {

        String result = patientDao.delete(1);

        assertEquals("Patient deleted", result);
        assertNull(patientDao.find(1));
    }


    // --------------------------------------------------
    // 6️⃣ Service Workflow Test
    // --------------------------------------------------
    @Test
    void testServiceWorkflow() {

        // Create Doctor
        Doctor doctor = new Doctor();
        doctor.setDoctorId(5);
        doctor.setDoctorName("Dr. Sharma");
        doctor.setDoctorSpecialization("Neurology");
        doctorDao.insert(doctor);

        // Create Patient + MedicalRecord
        Patient patient = new Patient();
        patient.setPatientId(50);
        patient.setPatientName("Rahul");
        patient.setPatientAge(30);
        patient.setPatientContact("8888888888");

        MedicalRecord record = new MedicalRecord();
        record.setMedicalId(500);
        record.setMedicalBloodGroup("A+");
        record.setMedicalAllergies("Dust");

        service.registerPatientWithMedicalRecord(patient, record);

        // Create Appointment
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(5000);
        appointment.setAppointmentVisitDate("2026-02-25");
        appointment.setAppointmentFee(1200);

        service.addAppointmentsToDoctor(5, List.of(appointment));

        service.assignAppointmentToPatient(5000, 50);

        assertNotNull(patientDao.find(50));
        assertNotNull(doctorDao.find(5));
    }


    @AfterAll
    static void cleanup() {
        patientDao.close();
    }
}
