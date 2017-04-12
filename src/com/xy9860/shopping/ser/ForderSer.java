package com.xy9860.shopping.ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xy9860.shopping.impl.ForderImpl;
import com.xy9860.shopping.pojo.Forder;
import com.xy9860.shopping.pojo.Goods;
import com.xy9860.shopping.pojo.Sorder;
import com.xy9860.shopping.pojo.Users;

public class ForderSer extends HttpServlet {

	private ForderImpl forderImpl = new ForderImpl();

	/**
	 * 
	 */
	private static final long serialVersionUID = -4094354693689626480L;

	/**
	 * Constructor of the object.
	 */
	public ForderSer() {
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
		if (status.equals("buy")) {
			//从Session中取出Forder,把购物项放进去,然后再把Forder放回Session
			Forder forder=(Forder)request.getSession().getAttribute("forder");
			Sorder sorder=new Sorder();//创建一个子订单实体
			Goods goods=new Goods();
			goods.setGid(Integer.parseUnsignedInt(request.getParameter("gid")));
			sorder.setGoods(goods);
			sorder.setSname(request.getParameter("gname"));
			sorder.setSnumber(1);
			sorder.setSprice(Double.parseDouble(request.getParameter("gprice")));
			//forder.getSorders().add(sorder);//放到订单里面的子订单set//这里实际上进行了业务逻辑的操作
			forder=forderImpl.addSorder(forder, sorder);
			request.getSession().setAttribute("forder", forder);
			response.sendRedirect(request.getContextPath()+"/users/showCar.jsp");
		}else if (status.equals("delForder")) {
			request.getSession().setAttribute("forder", new Forder());
			response.sendRedirect(request.getContextPath()+"/users/showCar.jsp");
		}else if (status.equals("delSorder")) {
			Forder forder=(Forder)request.getSession().getAttribute("forder");//从session中取出购物车实体
			forder=forderImpl.delSorder(forder, Integer.parseInt(request.getParameter("gid")));
			request.getSession().setAttribute("forder", forder);
			response.sendRedirect(request.getContextPath()+"/users/showCar.jsp");
		}else if (status.equals("saveForder")) {
			Forder forder=(Forder)request.getSession().getAttribute("forder");//从session中取出购物车实体
			Users users=(Users)request.getSession().getAttribute("users");
			forder.setFname(request.getParameter("fname"));
			forder.setFphone(request.getParameter("fphone"));
			forder.setFemail(request.getParameter("femail"));
			forder.setFpost(request.getParameter("fpost"));
			forder.setFremark(request.getParameter("fremark"));
			forder.setFaddress(request.getParameter("faddress"));
			forder.setUsers(users);
			forder=forderImpl.saveForder(forder);
			request.getSession().setAttribute("forder", forder);
			response.sendRedirect(request.getContextPath()+"/users/chooseBank.jsp");
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
