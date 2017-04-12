package com.xy9860.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xy9860.shopping.dao.IUsers;
import com.xy9860.shopping.pojo.Users;
import com.xy9860.shopping.util.DBConn;

public class UsersImpl implements IUsers {

	@Override
	public Users queryUsers(Users users) {
		// TODO Auto-generated method stub
		Users temp=null;
		String sql="select * from users where ulogin=? and upass=?";
		Connection conn=null;
		PreparedStatement ps=null;
		DBConn dbconn=new DBConn();
		conn=dbconn.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, users.getUlogin());
			ps.setString(2, users.getUpass());
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				temp=new  Users();
				temp.setUid(rs.getInt("uid"));
				temp.setUlogin(rs.getString("ulogin"));
				temp.setUname(rs.getString("uname"));
				temp.setUpass(rs.getString("upass"));
				temp.setUsex(rs.getString("usex"));
				temp.setUphone(rs.getString("uphone"));
				temp.setUpost(rs.getString("upost"));
				temp.setUemail(rs.getString("uemail"));
				temp.setUaddress(rs.getString("uaddress"));
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
