package com.passport;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PassportDaOTest {

    static EntityManagerFactory emf;

    @BeforeAll
    public static void init() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    // ---------------- INSERT SUCCESS ----------------
    @Test
    public void insertPassportTest() {
        PassportDaO dao = new PassportDaO();

        Passport p = new Passport();
        p.setPassportNo(100);
        p.setName("TestUser");
        p.setGender("Male");
        p.setAddress("Delhi");
        p.setNoOfTravels(2);

        String result = dao.insert(p);
        assertEquals("Passport inserted", result);
    }

    // ---------------- INSERT NULL ----------------
    @Test
    public void insertPassportNullTest() {
        PassportDaO dao = new PassportDaO();

        String result = dao.insert(null);
        assertEquals("Illegal Argument", result);
    }

    // ---------------- FIND SUCCESS ----------------
    @Test
    public void findPassportTest() {
        PassportDaO dao = new PassportDaO();

        Passport p = dao.find(100);
        assertNotNull(p);
    }

    // ---------------- FIND NOT FOUND ----------------
    @Test
    public void findPassportNotFoundTest() {
        PassportDaO dao = new PassportDaO();

        Passport p = dao.find(9999);
        assertNull(p);
    }

    // ---------------- UPDATE SUCCESS ----------------
    @Test
    public void updatePassportTest() {
        PassportDaO dao = new PassportDaO();

        String result = dao.update(100, "Mumbai", 5);
        assertEquals("Passport updated", result);
    }

    // ---------------- UPDATE NOT FOUND ----------------
    @Test
    public void updatePassportNotFoundTest() {
        PassportDaO dao = new PassportDaO();

        String result = dao.update(9999, "Chennai", 3);
        assertEquals("Passport not found", result);
    }

    // ---------------- DELETE SUCCESS ----------------
    @Test
    public void deletePassportTest() {
        PassportDaO dao = new PassportDaO();

        String result = dao.delete(100);
        assertEquals("Passport deleted", result);
    }

    // ---------------- DELETE NOT FOUND ----------------
    @Test
    public void deletePassportNotFoundTest() {
        PassportDaO dao = new PassportDaO();

        String result = dao.delete(9999);
        assertEquals("Passport not found", result);
    }

    // ---------------- FIND ALL ----------------
    @Test
    public void findAllPassportTest() {
        PassportDaO dao = new PassportDaO(); 

        List<Passport> list = dao.findAll();
        assertNotNull(list);
    }

    @AfterAll
    public static void destroy() {
        emf.close();
    }
}