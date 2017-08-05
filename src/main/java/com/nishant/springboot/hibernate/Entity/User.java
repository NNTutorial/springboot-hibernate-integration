package com.nishant.springboot.hibernate.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="USER_TABLE")
public class User {
	@TableGenerator(
			name="empGen",
			table="ID_GEN",
			pkColumnName="GEN_KEY",
			valueColumnName="GEN_VALUE",
			pkColumnValue="EMP_ID",
			allocationSize=1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="empGen")
	@Column(name="USER_ID")
	private int userid;
	
	@NotNull
	@Column(name="USER_NAME")
	private String username;
	
	@NotNull
	@Column(name="USER_ADDRESS")
	private String useraddress;
	
	@Column(name="USER_COMPANY_NAME")
	private String usercompanyname;

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public String getUsercompanyname() {
		return usercompanyname;
	}
	public void setUsercompanyname(String usercompanyname) {
		this.usercompanyname = usercompanyname;
	}



}
