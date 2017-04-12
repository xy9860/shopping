package com.xy9860.shopping.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xy9860.shopping.dao.ICategory;
import com.xy9860.shopping.impl.CategoryImpl;
import com.xy9860.shopping.pojo.Category;

public class ConextListener implements ServletContextListener {

	private ICategory categoryImpl=new CategoryImpl();

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		List<Category> cyList=categoryImpl.queryCategory("");
		event.getServletContext().setAttribute("cyList",cyList);
		ShoppingTimerTask shoppingTimerTask=new ShoppingTimerTask();
		shoppingTimerTask.setApplication(event.getServletContext());
		new Timer().schedule(shoppingTimerTask, 0, 1000*5);
		//把银行图标缓存到application里面
		File file=new File(event.getServletContext().getRealPath("/")+"image/bank");
		/*if (file.isDirectory()) {
			String[] fileNames=file.list(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					String s=name.substring(name.indexOf("."+1));
					if (s.equals("jpg")||s.equals("gif")) {
						return true;
					} else {
						return false;
					}
				}
			});
			event.getServletContext().setAttribute("fileNames",fileNames);
		}*/
		String[] fileNames = null;
		if (file.isDirectory()) {
			fileNames = file.list(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					String ext = name.substring(name.indexOf(".") + 1);
					if (ext.equals("gif") || ext.equals("jpg")){
						return true;
					}else{
						return false;
					}
				}
			});
			event.getServletContext().setAttribute("fileNames", fileNames);
		}

	}

}
