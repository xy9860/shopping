package com.xy9860.shopping.impl;

import java.sql.*;

import com.xy9860.shopping.dao.IAccount;
import com.xy9860.shopping.pojo.Account;
import com.xy9860.shopping.util.DBConn;

public class AccountImpl implements IAccount {

	@Override
	public Account queryAccount(Account account) {//执行查询操作,成功返回Account,失败返回null
		Account temp=null;
		String sql="select * from account where alogin=? and apass=?";
		Connection conn=null;
		PreparedStatement ps=null;
		DBConn dbconn=new DBConn();
		conn=dbconn.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, account.getAlogin());
			ps.setString(2, account.getApass());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				temp=new  Account();
				temp.setAid(rs.getInt("aid"));
				temp.setAlogin(rs.getString("alogin"));
				temp.setApass(rs.getString("apass"));
				temp.setAname(rs.getString("aname"));

			}
			if(rs!=null){

				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null){

					conn.close();
				}
				if(ps!=null){

					ps.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return temp;
	}

}
