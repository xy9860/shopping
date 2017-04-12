package com.xy9860.shopping.pojo;

import java.util.HashSet;
import java.util.Set;

public class Forder {
	private int fid;
	private String fdate;
	private double ftotal;
	private String fname;
	private String fphone;
	private String fremark;
	private String femail;
	private String faddress;
	private String fpost;
	private Users users;
	private int aid;
	private Status status;
	private Set<Sorder> sorders=new HashSet<Sorder>();
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public double getFtotal() {
		return ftotal;
	}
	public void setFtotal(double ftotal) {
		this.ftotal = ftotal;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFphone() {
		return fphone;
	}
	public void setFphone(String fphone) {
		this.fphone = fphone;
	}
	public String getFremark() {
		return fremark;
	}
	public void setFremark(String fremark) {
		this.fremark = fremark;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getFpost() {
		return fpost;
	}
	public void setFpost(String fpost) {
		this.fpost = fpost;
	}
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Set<Sorder> getSorders() {
		return sorders;
	}
	public void setSorders(Set<Sorder> sorders) {
		this.sorders = sorders;
	}
	public String getFaddress() {
		return faddress;
	}
	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}
	
}
