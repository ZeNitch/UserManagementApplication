package com.ivan.model;
import java.util.Date;
public class User {
	
	 private int userID;
	 private String firstName;
	 private String lastName;
	 private Date dateOfBirth;
	 private String phoneNumber;
	 private String email;
	 
	 //userID getter/setter
	 public int getUserId() {
	        return userID;
	    }
	 public void setUserId(int userID) {
	        this.userID = userID;
	    }
	 //firstName getter/setter
	 public String getFirstName()
	 {
		 return firstName;
	 }
	 public void setFirstName(String firstName)
	 {
		 this.firstName=firstName;
	 }
	 //lastName getter/setter
	 public String getLastName()
	 {
		 return lastName;
	 }
	 public void setLastName(String lastName)
	 {
		 this.lastName=lastName;
	 }
	 
	 //dateOfBirth getter/setter
	 public Date getDateOfBirth()
	 {
		 return dateOfBirth;
	 }
	 public void setDateOfBirth(Date dateOfBirth)
	 {
		 this.dateOfBirth=dateOfBirth;
	 }
	 //phone getter/setter
	 public String getPhoneNumber()
	 {
		 return phoneNumber;
	 }
	 public void setPhoneNumber(String phoneNumber)
	 {
		 this.phoneNumber=phoneNumber;
	 }
	 //email getter/setter
	 public String getEmail()
	 {
		 return email;
	 }
	 public void setEmail(String email)
	 {
		 this.email=email;
	 }

}
