package com.green.bank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;

import com.green.bank.model.AccountModel;
import com.green.bank.model.DepositSchemeModel;
import com.green.bank.model.LoanModel;

public class DatabaseOperations {
	Connection conn;
	int count1, count2;

	public boolean insertAccountDetails(AccountModel model) throws Exception {
		try {
			JDBC_Connect connect = new JDBC_Connect();
			conn = connect.getConnection();
			PreparedStatement ps1 = conn.prepareStatement("insert into account(id,f_name,l_name,address,city,"
					+ "branch,zip,username,password,phone,email,account_type,reg_date) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps1.setString(1, model.getAccount_no());
			ps1.setString(2, model.getFirst_name());
			ps1.setString(3, model.getLast_name());
			ps1.setString(4, model.getAddress());
			ps1.setString(5, model.getCity());
			ps1.setString(6, model.getBranch());
			ps1.setString(7, model.getZip());
			ps1.setString(8, model.getUsername());
			ps1.setString(9, model.getPassword());
			ps1.setString(10, model.getPhone_number());
			ps1.setString(11, model.getEmail());
			ps1.setString(12, model.getAccount_type());
			ps1.setString(13, model.getReg_date());

			count1 = ps1.executeUpdate();
			System.out.println("Inserted " + count1 + " row");

			PreparedStatement ps2 = conn.prepareStatement("insert into amount(id,amount) values(?,?)");
			ps2.setString(1, model.getAccount_no());
			ps2.setInt(2,model.getAmount());
			
			count2 = ps2.executeUpdate();

			System.out.println("Inserted " + count2 + " row");

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ((count1 > 0) && (count2 > 0));
	}

	public boolean insertLoanDetails(LoanModel model) throws Exception {
		try {
			JDBC_Connect connect = new JDBC_Connect();
			conn = connect.getConnection();
			PreparedStatement ps1 = conn
					.prepareStatement("insert into loan(id,amount,status,first_name,last_name,address,email) values('"
							+ model.getAccount_no() + "','" + model.getLoan_amount() + "','" + model.getStatus() + "','"
							+ model.getFirst_name() + "','" + model.getLast_name() + "','" + model.getAddress() + "','"
							+ model.getEmail() + "')");
			count1 = ps1.executeUpdate();

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (count1 > 0);
	}

	public AccountModel getAccountDetails(Connection conn, String account_no) throws Exception {
		AccountModel am = new AccountModel();

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from account where id ='" + account_no + "'");
		while (rs.next()) {

			// Setting all variables to model class
			am = new AccountModel();
			am.setAccount_no(rs.getString(1));
			am.setFirst_name(rs.getString(2));
			am.setLast_name(rs.getString(3));
			am.setAddress(rs.getString(4));
			am.setCity(rs.getString(5));
			am.setBranch(rs.getString(6));
			am.setZip(rs.getString(7));
			am.setUsername(rs.getString(8));
			am.setPassword(rs.getString(9));
			am.setPhone_number(rs.getString(10));
			am.setEmail(rs.getString(11));
			am.setAccount_type(rs.getString(12));
			am.setReg_date(rs.getString(13));
		}
		ResultSet rs1 = stmt.executeQuery("select * from amount where id ='" + am.getAccount_no() + "'");
		while (rs1.next()) {
			am.setAmount(rs1.getInt(2));
		}
		return am;
	}

	public boolean insertDepositScheme(DepositSchemeModel model) throws Exception {
		try {
			JDBC_Connect connect = new JDBC_Connect();
			conn = connect.getConnection();

			// getting current date
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			String current_time = dateFormat.format(date);

			PreparedStatement ps1 = conn
					.prepareStatement("insert into deposit(id,year,interest,amount,deposit_date) values('"
							+ model.getAccount_no() + "','" + model.getYear() + "','" + model.getInterest_rate() + "','"
							+ model.getAmount() + "','" + current_time + "')");
			count1 = ps1.executeUpdate();
			System.out.println("Inserted " + count1 + " row");

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ((count1 > 0));
	}

	public ArrayList<LoanModel> getLoanList(Connection conn) throws Exception {
		ArrayList<LoanModel> loanList = new ArrayList<>();
		LoanModel loanModel;

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from loan where status='pending'");
		while (rs.next()) {
			loanModel = new LoanModel();
			loanModel.setAccount_no(rs.getString(1));
			loanModel.setLoan_amount(rs.getInt(2));
			loanModel.setStatus(rs.getString(3));
			loanModel.setFirst_name(rs.getString(4));
			loanModel.setLast_name(rs.getString(5));
			loanModel.setAddress(rs.getString(6));
			loanModel.setEmail(rs.getString(7));

			loanList.add(loanModel);

		}

		return loanList;

	}

	public void UpdateAmount(String account_no, int loan_amount) throws SQLException {
		int current_amount = 0;
		JDBC_Connect connect = new JDBC_Connect();
		Connection conn = connect.getConnection();

		Statement stmt = conn.createStatement();
		ResultSet rs1 = stmt.executeQuery("select * from amount where id ='" + account_no + "'");

		while (rs1.next()) {
			current_amount = rs1.getInt(2);

		}

		current_amount += loan_amount;

		// Updating Loan amount
		PreparedStatement ps = conn.prepareStatement("update amount set amount=? where id= ?");
		ps.setInt(1, current_amount);
		ps.setString(2, account_no);
		ps.executeUpdate();

		PreparedStatement ps1 = conn.prepareStatement("update loan set status=? where id= ?");
		ps1.setString(1, "success");
		ps1.setString(2, account_no);
		ps1.executeUpdate();

		conn.close();

	}
	public int ChangePassword(String account_no, String old_password, String new_password) throws SQLException {
		
		JDBC_Connect connect = new JDBC_Connect();
		Connection conn = connect.getConnection();
		String pass;
		int check=0;

		Statement stmt = conn.createStatement();
		ResultSet rs1 = stmt.executeQuery("select * from account where id ='" + account_no + "'" );
		while (rs1.next()) {
			pass = rs1.getString("password");
			
		}
		pass=new_password;
		System.out.println(pass);
		PreparedStatement ps = conn.prepareStatement("update account set password=? where id= ?");
		ps.setString(1, pass);
		ps.setString(2, account_no);
		check=ps.executeUpdate();

		conn.close();
		return check;
		
		
	}
}
