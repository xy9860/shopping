package com.xy9860.shopping.impl;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xy9860.shopping.pojo.Account;
import com.xy9860.shopping.pojo.Category;

public class CategoryImplTest {

	private static CategoryImpl categoryImpl=null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryImpl=new CategoryImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		categoryImpl=null;
	}

	@Test
	public void testSaveCategory() {
		Category category= new Category();
		category.setChot(false);
		category.setCid(4);
		category.setCtype("老年休闲");
		Account account=new Account();
		account.setAid(2);
		category.setAccount(account);
	}

	@Test
	public void testQueryCategoryString() {
		//断言,我查询出来的结果是5
		Assert.assertEquals("查出来的数目不对", 5, categoryImpl.queryCategory("").size());
	}

	@Test
	public void testQueryCategoryBoolean() {
		fail("Not yet implemented");
	}

}
