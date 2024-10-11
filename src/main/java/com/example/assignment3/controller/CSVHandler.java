package com.example.assignment3.controller;


import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CSVHandler extends SimpleTagSupport{
    private String csvFileName;

    public void setCsvFileName(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    @Override
    public void doTag() throws JspException, IOException {
//        super.doTag();
        JspWriter out = getJspContext().getOut();
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");

            if (csvFileName != null) {
                String jdbcUrl = "jdbc:relique:csv:" + "/Users/ameysatwe/syllabi/web-tools/assignment-2/src/main/webapp/WEB-INF";
                out.println("<table border='1'><tr>" +
                        "<th>Facility Type</th>" +
                        "<th>License Number</th>" +
                        "<th>Entity Name</th>" +
                        "<th>Camis Trade Name</th>" +
                        "<th>Address Bldg</th>" +
                        "<th>Address Street Name</th>" +
                        "<th>Address Location</th>" +
                        "<th>Address State</th>" +
                        "<th>Address Zip Code</th>" +
                        "<th>Telephone Number</th>" +
                        "<th>Number of Spaces</th>" +
                        "</tr>");

                try (Connection conn = DriverManager.getConnection(jdbcUrl);
                     Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT * FROM " + csvFileName)) {

                    while (rs.next()) {
                        out.println("<tr><td>" + rs.getString("Facility Type") + "</td>");
                        out.println("<td>" + rs.getString("License Number") + "</td>");
                        out.println("<td>" + rs.getString("Entity Name") + "</td>");
                        out.println("<td>" + rs.getString("Camis Trade Name") + "</td>");
                        out.println("<td>" + rs.getString("Address Bldg") + "</td>");
                        out.println("<td>" + rs.getString("Address Street Name") + "</td>");
                        out.println("<td>" + rs.getString("Address Location") + "</td>");
                        out.println("<td>" + rs.getString("Address State") + "</td>");
                        out.println("<td>" + rs.getString("Address Zip Code") + "</td>");
                        out.println("<td>" + rs.getString("Telephone Number") + "</td>");
                        out.println("<td>" + rs.getString("Number of Spaces") + "</td></tr>");
                    }
                } catch (Exception e) {
                    out.println("<p>Error processing CSV file: " + e.getMessage() + "</p>");
                }

                out.println("</table>");
            }
        } catch (Exception e) {
            throw new JspException("Error in CsvTag", e);
        }    }
}
