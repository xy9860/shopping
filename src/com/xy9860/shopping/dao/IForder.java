package com.xy9860.shopping.dao;

import com.xy9860.shopping.pojo.Forder;
import com.xy9860.shopping.pojo.Sorder;

public interface IForder {
	public Forder addSorder(Forder forder,Sorder sorder);
	public double cluTotal(Forder forder);
	public Forder delSorder(Forder forder,int gid);
	public Forder saveForder(Forder forder);
}
