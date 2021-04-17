package com.green.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.green.bank.database.JDBC_Connect;
import com.green.bank.model.AccountModel;

@SuppressWarnings("serial")
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	String UserName, password;
	Connection conn;
	Statement stmt;
	AccountModel am = null;
	boolean pass_wrong = false;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserName = request.getParameter("UserName");
		password = request.getParameter("password");

		System.out.println(UserName);
		System.out.println(password);

		try {
			// Getting database connection
			System.out.println("I am in try login ser ");

			JDBC_Connect connect = new JDBC_Connect();
			conn = connect.getConnection();

			stmt = conn.createStatement();
			String s = "select * from account where username ='" + UserName + "'" + "and password='" + password + "'";

			ResultSet rs = stmt.executeQuery(s);

			if (!rs.next()) {
				System.out.println("I am in try -if -login ser ");

				request.setAttribute("isPassOK", "No");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("I am in try-else- login ser ");
				// String s1= "select * from account where username ='" + UserName + "'" + "and
				// password='" + password + "'";

				// ResultSet rs1 = stmt.executeQuery(s1);

				// while (rs1.next()) {
				pass_wrong = true;
				// Setting all variables to model class
				am = new AccountModel();
				am.setAccount_no(rs.getString("ID"));
				am.setFirst_name(rs.getString("F_NAME"));
				am.setLast_name(rs.getString("L_NAME"));
				am.setAddress(rs.getString("ADDRESS"));
				am.setCity(rs.getString("CITY"));
				am.setBranch(rs.getString("BRANCH"));
				am.setZip(rs.getString("ZIP"));
				am.setUsername(rs.getString("USERNAME"));
				am.setPassword(rs.getString("PASSWORD"));
				am.setPhone_number(rs.getString("PHONE"));
				am.setEmail(rs.getString("EMAIL"));
				am.setAccount_type(rs.getString("ACCOUNT_TYPE"));
				am.setReg_date(rs.getString("REG_DATE"));

				String s2 = "select * from amount where id ='" + am.getAccount_no() + "'";

				ResultSet rs2 = stmt.executeQuery(s2);

				while (rs2.next()) {
					am.setAmount(rs2.getInt("AMOUNT"));
				}

				// Setting Session variable for current User
				HttpSession session = request.getSession();
				session.setAttribute("userDetails", am);

				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);

			}
			// }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
