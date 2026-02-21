package com.assignment5;



import java.util.Arrays;

public class CrmMain {

    public static void main(String[] args) {

        // ============================
        // 1️⃣ Register Customer
        // ============================
        CustomerService.registerCustomer(
                "Driti Sai",
                "dritisai@gmail.com",
                "9704490499");

        // ============================
        // 2️⃣ Add Address to Customer
        // ============================
        CustomerService.addAddress(
                1,
                "Nellore",
                "Andhra Pradesh",
                "524004");

        // ============================
        // 3️⃣ Create Lead
        // ============================
        LeadService.createLead(
                "New Customer",
                "Online",
                "9876543210");

        // ============================
        // 4️⃣ Assign Lead to Employee
        // ============================
        LeadService.assignLead(1, 1);

        // ============================
        // 5️⃣ Add Products
        // ============================
        ProductService.addProduct("Laptop", 80000);
        ProductService.addProduct("Mouse", 1000);
        ProductService.addProduct("Keyboard", 2000);

        // ============================
        // 6️⃣ Place Order
        // ============================
        OrderService.placeOrder(
                1,
                Arrays.asList(1L, 2L, 3L),
                "2026-02-21");

        // ============================
        // 7️⃣ Raise Support Ticket
        // ============================
        TicketService.raiseSupportTicket(
                1,
                "Product damaged",
                "OPEN");

        // ============================
        // 8️⃣ Employee Performance Report
        // ============================
        ReportService.getEmployeePerformance(1);

        // ============================
        // 9️⃣ Total Revenue Report
        // ============================
        ReportService.getTotalRevenue();

        System.out.println("✅ All CRM operations executed successfully!");
    }
}