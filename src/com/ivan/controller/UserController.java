package com.ivan.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ivan.dao.UserDAO;
import com.ivan.model.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/User.jsp";
	private static String LIST_USER = "/listUser.jsp";
	private UserDAO dao;
	
	public UserController() {
		super();
		dao = new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			int id = Integer.parseInt(request.getParameter("userId"));
			dao.deleteUser(id);
			forward = LIST_USER;
			request.setAttribute("users", dao.getUsers());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int id = Integer.parseInt(request.getParameter("userId"));
			User user = dao.getUserByID(id);
			request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			request.setAttribute("users", dao.getUsers());
		} else if (action.equalsIgnoreCase("sortLastName")) {
			forward = LIST_USER;
			request.setAttribute("users", dao.sortBy("LastName"));
		} else if (action.equalsIgnoreCase("sortDate")) {
			forward = LIST_USER;
			request.setAttribute("users", dao.sortBy("DateOfBirth"));
		} else {
			forward = INSERT_OR_EDIT;
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("search")) {
			String parameter = request.getParameter("par");
			forward = LIST_USER;
			request.setAttribute("users", dao.searchBy(parameter));
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		} else {
			User user = new User();
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			try {
				Date dateOfBirth = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dateOfBirth"));
				user.setDateOfBirth(dateOfBirth);
			} catch (ParseException e) {
				user.setDateOfBirth(new Date());
			}
			user.setPhoneNumber(request.getParameter("phoneNumber"));
			user.setEmail(request.getParameter("email"));
			String id = request.getParameter("userId");
			if (id == null || id.isEmpty()) {
				dao.createUser(user);
			} else {
				user.setUserId(Integer.parseInt(id));
				dao.updateUser(user);
			}
			RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
			request.setAttribute("users", dao.getUsers());
			view.forward(request, response);
		}
	}
}
