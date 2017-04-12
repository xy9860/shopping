package com.xy9860.shopping.impl;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xy9860.shopping.pojo.Forder;
import com.xy9860.shopping.pojo.Goods;
import com.xy9860.shopping.pojo.Sorder;
import com.xy9860.shopping.pojo.Status;
import com.xy9860.shopping.pojo.Users;

public class ForderImplTest {

	private static ForderImpl forderImpl=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//此方法在所有方法执行前执行,用来创建测试对象
		forderImpl=new ForderImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//此方法在所有测试方法之后执行,用来销毁对象
		forderImpl=null;
	}

	@Test
	public void testAddSorder() {
		fail("Not yet implemented");
	}

	@Test
	public void testCluTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelSorder() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveForder() {
		//用户登陆成功,将返回用户对象
		Users users=new Users();
		users.setUid(1);
		Forder forder=new Forder();
		//users放进去
		forder.setUsers(users);
		//购买的商品
		Sorder sorder=new Sorder();
		sorder.setFid(1);
		Goods goods=new Goods();
		goods.setGid(20170219);
		sorder.setGoods(goods);
		sorder.setSid(1);
		sorder.setSname("11");
		sorder.setSnumber(12313);
		sorder.setSprice(111);
		//把商品添加进购物车中
		forder .getSorders().add(sorder);
		forder.setAid(1);
		forder.setFaddress("11");
		forder.setFdate("2017-02-23 17:24:25");
		forder.setFemail("111");
		forder.setFname("111");
		forder.setFtotal(1111);
		forder.setFphone("1111");
		forder.setFpost("1111");
		forder.setFremark("2222222");
		Status status=new Status();
		status.setSid(1);
		forder.setStatus(status);
		forderImpl.saveForder(forder);
	}

}
