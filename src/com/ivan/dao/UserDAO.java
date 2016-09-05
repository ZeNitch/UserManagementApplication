package com.ivan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ivan.model.User;
import com.ivan.utilization.DBUtilization;

public class UserDAO {

	private Connection connection;
	
	public UserDAO()
	{
		connection=DBUtilization.getConnection();
	}
	public void createUser(User user)
	{
		Date cup=null;
		try {
			PreparedStatement  preparedStatement = connection.prepareStatement("insert into user(FirstName,LastName,DateOfBirth,PhoneNumber,Email) values (?,?,?,?,?)");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDateOfBirth().getTime()));
			preparedStatement.setString(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getUsers()
	{
		List<User> users = new ArrayList<User>();
		try {
			
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from user");
			while(rs.next())
			{
				User user = new User();
				user.setUserId(rs.getInt("UserID"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setDateOfBirth(rs.getDate("DateOfBirth"));
				user.setPhoneNumber(rs.getString("PhoneNumber"));
				user.setEmail(rs.getString("Email"));
				users.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return users;	
	}
	public List<User> sortBy(String param)
	{
		List<User> users = new ArrayList<User>();
		try {
			
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery(String.format("select * from user order by %s", param));
			while(rs.next())
			{
				User user = new User();
				user.setUserId(rs.getInt("UserID"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setDateOfBirth(rs.getDate("DateOfBirth"));
				user.setPhoneNumber(rs.getString("PhoneNumber"));
				user.setEmail(rs.getString("Email"));
				users.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return users;	
	}
	public List<User> searchBy(String param)
	{
		List<User> users = new ArrayList<User>();
		try {
			
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery(String.format("select * from user where UserID like \'%1$s\'"
					+ " or FirstName like \'%1$s\'"
					+ " or LastName like \'%1$s\'"
					+ " or DateOfBirth like \'%1$s\'"
					+ " or PhoneNumber like \'%1$s\'"
					+ " or Email like \'%1$s\' ", param));
			while(rs.next())
			{
				User user = new User();
				user.setUserId(rs.getInt("UserID"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setDateOfBirth(rs.getDate("DateOfBirth"));
				user.setPhoneNumber(rs.getString("PhoneNumber"));
				user.setEmail(rs.getString("Email"));
				users.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return users;	
	}
	public void updateUser(User user)
	{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update user set FirstName=?, LastName=?, DateOfBirth=?,PhoneNumber=?, Email=?" +
                    "where UserID=?");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(user.getDateOfBirth().getTime()));
			preparedStatement.setString(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setInt(6, user.getUserId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void deleteUser(int id)
	{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from user where UserID=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public User getUserByID(int id)
	{
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where UserID=?");
			preparedStatement.setInt(1, id);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				user.setUserId(rs.getInt("UserID"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setDateOfBirth(rs.getDate("DateOfBirth"));
				user.setPhoneNumber(rs.getString("PhoneNumber"));
				user.setEmail(rs.getString("Email"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return user;
	}

}
