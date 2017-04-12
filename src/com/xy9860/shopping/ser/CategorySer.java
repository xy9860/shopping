package com.xy9860.shopping.ser;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xy9860.shopping.dao.ICategory;
import com.xy9860.shopping.impl.CategoryImpl;
import com.xy9860.shopping.pojo.Account;
import com.xy9860.shopping.pojo.Category;

public class CategorySer extends HttpServlet {
	
	private ICategory categoryImpl=new CategoryImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6014733920558187830L;

	/**
	 * Constructor of the object.
	 */
	public CategorySer() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status=request.getParameter("status");
		if(status.equals("saveCategory")){
			Category category=new Category();
			category.setCtype(request.getParameter("ctype"));
			category.setChot(Boolean.parseBoolean(request.getParameter("chot")));
			category.setAccount((Account)request.getSession().getAttribute("account"));
			categoryImpl.saveCategory(category);
			response.sendRedirect(request.getContextPath()+"/admin/main.jsp");
			List<Category> cyList=categoryImpl.queryCategory("");
			this.getServletContext().setAttribute("cyList",cyList);
		}else if(status.equals("queryCategory")){
			String ctype=request.getParameter("ctype");
			List<Category> cyList=categoryImpl.queryCategory(ctype);
			request.setAttribute("cyList", cyList);
			request.getRequestDispatcher("/admin/queryCategory.jsp").forward(request, response);
		}else if (status.equals("checkCtype")) {
			//调用查询类别的方法,返回true说明类别有,为false说明类别没有
			String ctype=request.getParameter("ctype");
			String flag="false";
			List<Category> categorys=categoryImpl.queryCategory(ctype);
			if (categorys.size()>0) {
				for (Category category : categorys) {
					if (category.getCtype().equals(ctype)) {
						flag="true";
					}
				}
			}
			//向客户端的缓存输出页面,不是返回页面
			response.getWriter().write(flag);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
