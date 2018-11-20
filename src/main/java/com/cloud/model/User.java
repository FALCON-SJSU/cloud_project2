package com.cloud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userfirstname;
	private String userlastname;
	private String useremailid;
	private String userpassword;
	
	public User()
	{
		
	}
	
	public User(int userId, String userfirstname, String userlastname, String useremailid, String userpassword ) {
		super();
		this.userId = userId;
		this.userfirstname = userfirstname;
		this.userlastname = userlastname;
		this.useremailid = useremailid;
		this.userpassword = userpassword;
	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserfirstname() {
		return userfirstname;
	}

	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}

	public String getUserlastname() {
		return userlastname;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public String getUseremailid() {
		return useremailid;
	}

	public void setUseremailid(String useremailid) {
		this.useremailid = useremailid;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userfirstname=" + userfirstname + ", userlastname=" + userlastname
				+ ", useremailid=" + useremailid + " , userpassword=" + userpassword + "]";
	}
}