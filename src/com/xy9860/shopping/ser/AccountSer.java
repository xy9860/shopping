package com.xy9860.shopping.ser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xy9860.shopping.dao.IAccount;
import com.xy9860.shopping.impl.AccountImpl;
import com.xy9860.shopping.pojo.Account;

public class AccountSer extends HttpServlet {

	private IAccount accountImpl=new AccountImpl();//生成一个新的账户实现类(数据库的操作),使用接口来接收,便于使用多态进行控制
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2476608722947152886L;

	/**
	 * Constructor of the object.
	 */
	public AccountSer() {
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
		String status=request.getParameter("status");//取出隐藏的面板上面的值(用来设定传送类型)
		if(status.equals("login")){//确定类型
			Account account=new Account();
			account.setAlogin(request.getParameter("alogin"));//取出从页面获取的值
			account.setApass(request.getParameter("apass"));
			account = accountImpl.queryAccount(account);//执行查询操作,成功返回Account,失败返回null
			if(account==null){
				request.setAttribute("error", "对不起登陆失败!!!");//设置错误消息
				request.getRequestDispatcher("/alogin.jsp").forward(request, response);//内部跳转 forward()无法重定向至有frame的jsp文件
			}else{
				request.getSession().setAttribute("account", account);//写入session对象一对键值
				response.sendRedirect(request.getContextPath()+"/admin/index.jsp");//这个可以带参数,也可以传递到有frame的页面
			}
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
