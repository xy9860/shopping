package com.xy9860.shopping.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.xy9860.shopping.dao.ICategory;
import com.xy9860.shopping.dao.IGoods;
import com.xy9860.shopping.impl.CategoryImpl;
import com.xy9860.shopping.impl.GoodsImpl;
import com.xy9860.shopping.pojo.Category;
import com.xy9860.shopping.pojo.Goods;

public class ShoppingTimerTask extends TimerTask {

	private ICategory categoryImpl=new CategoryImpl();
	private IGoods goodsImpl=new GoodsImpl();
	private ServletContext application;
	
	public ServletContext getApplication() {
		return application;
	}

	public void setApplication(ServletContext application) {
		this.application = application;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//查询热点类别的推荐商品
		List<Goods> recommendGoods=new ArrayList<Goods>();//装热点商品的list
		List<List<Goods>> bigList=new ArrayList< List<Goods>>();//总仓库,存放list
		for(Category c:categoryImpl.queryCategory(true)){//查询出热点类别
			recommendGoods=goodsImpl.queryChotGoods(c);
			bigList.add(recommendGoods);
		}
		application.setAttribute("bigList", bigList);//为了显示首页上面的内容
	}

}
