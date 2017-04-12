package com.xy9860.shopping.ser;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xy9860.shopping.dao.IGoods;
import com.xy9860.shopping.impl.GoodsImpl;
import com.xy9860.shopping.pojo.Category;
import com.xy9860.shopping.pojo.Goods;

public class GoodsSer extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -795633456968729935L;
	private IGoods goodsImpl=new GoodsImpl();
	
	/**
	 * Constructor of the object.
	 */
	public GoodsSer() {
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
		if(status.equals("queryGoods")){
			String gname=request.getParameter("gname");
			String gremark=request.getParameter("gremark");
			Goods g=new Goods();
			g.setGname(gname);
			g.setGremark(gremark);
			List<Goods> gdList=goodsImpl.queryGoods(g);
			request.setAttribute("gdList", gdList);
			request.getRequestDispatcher("/admin/queryGoods.jsp").forward(request, response);
		}else if(status.equals("saveGoods")){
			Goods g=new Goods();
			//g.setGid(Integer.parseInt(request.getParameter("gid")));
			g.setGname(request.getParameter("gname"));
			g.setGprice(Double.parseDouble(request.getParameter("gprice")));
			g.setGpic(request.getParameter("gpic"));
			g.setGremark(request.getParameter("gremark"));
			g.setGxremark(request.getParameter("gxremark"));
			g.setGiscommend(Boolean.parseBoolean(request.getParameter("giscommend")));
			g.setGisopen(Boolean.parseBoolean(request.getParameter("gisopen")));
			Category c=new Category();
			c.setCid(Integer.parseInt(request.getParameter("cid")));
			g.setCategory(c);
			goodsImpl.saveGoods(g);
			request.getRequestDispatcher("/admin/queryGoods.jsp").forward(request, response);
		}else if (status.equals("checkGoods")) {
			String flag="false";
			String gname=request.getParameter("gname");
			Goods goods=new Goods();
			goods.setGname(gname);
			goods.setGremark("");
			List<Goods> goodss=goodsImpl.queryGoods(goods);//这里因为这个方法使用的是like查询
			if (goodss.size()>0) {
				for (Goods goods2 : goodss) {
					if (goods2.getGname().equals(gname)) {
						flag="true";//true表示有重复
					}
				}
			}
			response.getWriter().write(flag);//返回消息
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
