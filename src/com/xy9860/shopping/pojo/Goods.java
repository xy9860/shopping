package com.xy9860.shopping.pojo;

public class Goods {
	private int gid;
	private String gname;
	private double gprice;
	private String gpic;
	private String gremark;
	private String Gxremark;
	private String gdate=null;
	private boolean giscommend;
	private boolean gisopen;
	private Category category;//嵌套使用库的类,便于使用
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public double getGprice() {
		return gprice;
	}
	public void setGprice(double gprice) {
		this.gprice = gprice;
	}
	public String getGpic() {
		return gpic;
	}
	public void setGpic(String gpic) {
		this.gpic = gpic;
	}
	public String getGremark() {
		return gremark;
	}
	public void setGremark(String gremark) {
		this.gremark = gremark;
	}
	public String getGxremark() {
		return Gxremark;
	}
	public void setGxremark(String gxremark) {
		Gxremark = gxremark;
	}
	public boolean isGiscommend() {
		return giscommend;
	}
	public void setGiscommend(boolean giscommend) {
		this.giscommend = giscommend;
	}
	public boolean isGisopen() {
		return gisopen;
	}
	public void setGisopen(boolean gisopen) {
		this.gisopen = gisopen;
	}
	public String getGdate() {
		return gdate;
	}
	public void setGdate(String gdate) {
		this.gdate = gdate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
