package com.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.dao.CustomerDao;
import com.customer.dto.Customer;

@WebServlet("/create")
public class CustomerCreate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String street = req.getParameter("street");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		Customer customer = new Customer();
		customer.setFirst_name(first_name);
		customer.setLast_name(last_name);
		customer.setStreet(street);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setState(state);
		customer.setEmail(email);
		customer.setPhone(phone);
		CustomerDao customerDao = new CustomerDao();
		customerDao.create(customer);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/fetchall");
		dispatcher.forward(req, resp);
      
	}
}
