package com.green.bank;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.bank.database.DatabaseOperations;
@SuppressWarnings("serial")
@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet{
	String account_no,old_password,new_password;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		account_no = request.getParameter("account_no");
		old_password =(request.getParameter("pass"));
		new_password = request.getParameter("password");
		

	
	
	try {
		
		DatabaseOperations operations = new DatabaseOperations();
		int check =  operations.ChangePassword(account_no, old_password, new_password);
		if(check!=0){
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("change_password.jsp");
			rd.forward(request, response);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
}
