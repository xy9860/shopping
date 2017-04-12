package com.xy9860.shopping.ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xy9860.shopping.dao.IUsers;
import com.xy9860.shopping.impl.UsersImpl;
import com.xy9860.shopping.pojo.Forder;
import com.xy9860.shopping.pojo.Users;

public class UsersSer extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8007291923719092452L;
	private IUsers usersImpl=new UsersImpl();
	
	/**
	 * Constructor of the object.
	 */
	public UsersSer() {
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
		String status = request.getParameter("status");
		if(status.equals("login")){
			Users users=new Users();
			users.setUlogin(request.getParameter("ulogin"));
			users.setUpass(request.getParameter("upass"));
			users=usersImpl.queryUsers(users);
			if(users==null){//登陆失败
				request.setAttribute("error", "用户或密码错误");
				request.getRequestDispatcher("/ulogin.jsp").forward(request, response);
			}else{//登陆成功
				Forder forder=new Forder();//创建一个购物车的类
				request.getSession().setAttribute("forder", forder);
				request.getSession().setAttribute("users", users);
				if(request.getSession().getAttribute("goUrl")==null){
					response.sendRedirect(request.getContextPath()+"/index.jsp");
				}else{
					//说明用户登陆成功后要跳转到先去的页面
					response.sendRedirect(request.getSession().getAttribute("goUrl").toString());
				}
			}
		}else if(status.equals("signout")){
			request.getSession().setAttribute("users", null);
			response.sendRedirect("/");
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
