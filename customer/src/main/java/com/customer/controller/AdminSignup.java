package com.customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.dao.CustomerDao;
import com.customer.dto.AdminDto;
@WebServlet("/admin")
public class AdminSignup extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	AdminDto adminDto=new AdminDto();
	String login_id=req.getParameter("login_id");
	String password=req.getParameter("password");
	adminDto.setLogin_id(login_id);
	adminDto.setPassword(password);
	CustomerDao customerDao=new CustomerDao();
	customerDao.adminRegister(adminDto);
	resp.sendRedirect("login.html");
	
}
}
