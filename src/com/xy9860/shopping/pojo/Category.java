package com.xy9860.shopping.pojo;

public class Category {
	private int cid;
	private String ctype;
	private boolean chot;
	private Account account;//嵌套使用库的类,便于使用
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public boolean isChot() {
		return chot;
	}
	public void setChot(boolean chot) {
		this.chot = chot;
	}
	
}
