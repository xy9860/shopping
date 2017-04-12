package com.xy9860.shopping.dao;

import java.util.List;

import com.xy9860.shopping.pojo.Category;

public interface ICategory {
	public void saveCategory(Category category);
	public List<Category> queryCategory(String ctype);
	public List<Category> queryCategory(boolean isChot);//这里使用重载,真的是在使用的时候想不起来,以后注意点这个问题
}
