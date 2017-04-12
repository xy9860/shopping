package com.xy9860.shopping.dao;

import java.util.List;

import com.xy9860.shopping.pojo.Category;
import com.xy9860.shopping.pojo.Goods;

public interface IGoods {
	public List<Goods> queryGoods(Goods goods);
	public List<Goods> queryChotGoods(Category c);
	public void saveGoods(Goods goods);
}
