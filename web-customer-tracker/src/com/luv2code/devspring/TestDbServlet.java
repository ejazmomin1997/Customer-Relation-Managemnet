package com.luv2code.devspring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

		String driver = "com.mysql.jdbc.Driver";
		try {
			PrintWriter printWriter = response.getWriter();
			System.out.println("connecting");
			Class.forName(driver);
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			printWriter.println("done");
			myConn.close();
		}
		catch(Exception ex) {
		
			ex.printStackTrace();
		}
	}

}
