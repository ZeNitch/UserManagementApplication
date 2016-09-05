package com.ivan.utilization;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtilization {

	private static Connection connection = null;
	
	public static Connection getConnection()
	{
		if(connection!=null)
		{
			return connection;
		}
		else
		{
			try
			{
				Properties prop = new Properties();
				InputStream in = DBUtilization.class.getClassLoader().getResourceAsStream("/db.properties");
				prop.load(in);
				String driver=prop.getProperty("driver");
				String url=prop.getProperty("url");
				String user=prop.getProperty("user");
				String passwd="";
				Class.forName(driver);
				connection=DriverManager.getConnection(url,user,passwd);
			}
			catch (ClassNotFoundException e)
			{
             e.printStackTrace();
			} 
			catch (SQLException e)
			{
             e.printStackTrace();
			}
			catch (FileNotFoundException e) 
			{
             e.printStackTrace();
			} 
			catch (IOException e)
			{
             e.printStackTrace();
			}			
         return connection;	
		}
	}
}
