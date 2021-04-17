package com.green.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
@WebServlet("/Transfer")
public class TransferServlet extends HttpServlet {
	String account_no, username, target_acc_no, password;
	Connection conn;
	Statement stmt;
	boolean pass_wrong = false;
	int own_amount, transfer_amount, recipient_amount;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("I am in do post trans");
		account_no = request.getParameter("account_no");
		username = request.getParameter("username");
		target_acc_no = request.getParameter("target_acc_no");
		password = request.getParameter("password");
		transfer_amount = Integer.parseInt(request.getParameter("amount"));

		try {

			System.out.println("I am in try block trans");
			JDBC_Connect connect = new JDBC_Connect();
			conn = connect.getConnection();

			stmt = conn.createStatement();
			System.out.println("I am in try block trans 2");

			String sql = "select * from account where username='" + username + "' and password='" + password + "'";

			ResultSet rsOwn = stmt.executeQuery(sql);
			if (rsOwn.next()) {
				System.out.println("I am in try block trans 3");

				String s = rsOwn.getString("id");
				System.out.println("I  " + s);

				if (s.equals(account_no)) {
					System.out.println("I  4 ");

					String sql1 = "select * from amount where id='" + target_acc_no + "'";
					ResultSet rsOwn1 = stmt.executeQuery(sql1);
					// String s1=rsOwn1.getString("id");

					if (rsOwn1.first()) {
						recipient_amount = rsOwn1.getInt(2);
						System.out.println("I 5 " + recipient_amount);
						rsOwn1.close();

						String sql2 = "select AMOUNT from amount where id='" + s + "'";

						ResultSet rsOwn2 = stmt.executeQuery(sql2);
						System.out.println(rsOwn2.next());
						// System.out.println("I " + rsOwn2.getInt(1));

						int money = rsOwn2.getInt(1);

						System.out.println("I mo " + money);

						if (money > transfer_amount) {
							System.out.println("I 6 ");

							money -= transfer_amount;

							recipient_amount += transfer_amount;

							PreparedStatement ps = conn.prepareStatement("update amount set amount=? where id= ?");
							ps.setInt(1, money);
							ps.setString(2, account_no);
							ps.executeUpdate();

							PreparedStatement ps1 = conn.prepareStatement("update amount set amount=? where id= ?");
							ps1.setInt(1, recipient_amount);
							ps1.setString(2, target_acc_no);
							ps1.executeUpdate();

							conn.close();

							RequestDispatcher rd = request.getRequestDispatcher("transfer_process.jsp");
							rd.forward(request, response);

						} else {
							System.out.println("I am in else1");
							conn.close();
							request.setAttribute("EnoughMoney", "No");
							RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
							rd.forward(request, response);

						}

					} else {
						System.out.println("I am in try else2 ");
						request.setAttribute("isPassOK", "No");
						RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
						rd.forward(request, response);

					}

				} else {
					System.out.println("I am in try else3 ");
					request.setAttribute("isPassOK", "No");
					RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
					rd.forward(request, response);
				}

			} else {
				System.out.println("I am in try else 4");
				request.setAttribute("isPassOK", "No");
				RequestDispatcher rd = request.getRequestDispatcher("transfer.jsp");
				rd.forward(request, response);

			}

			// Stay here

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
