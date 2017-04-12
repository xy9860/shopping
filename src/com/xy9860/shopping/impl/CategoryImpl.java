package com.xy9860.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy9860.shopping.dao.ICategory;
import com.xy9860.shopping.pojo.Account;
import com.xy9860.shopping.pojo.Category;
import com.xy9860.shopping.util.DBConn;

public class CategoryImpl implements ICategory {

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		String sql="insert into category values(?,?,?,?)";
		Connection conn=null;
		PreparedStatement ps=null;
		DBConn dbconn=new DBConn();
		conn=dbconn.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, null);
			ps.setString(2, category.getCtype());
			ps.setBoolean(3, category.isChot());
			ps.setInt(4, category.getAccount().getAid());
			ps.executeUpdate();
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

	}

	@Override
	public List<Category> queryCategory(String ctype) {
		List<Category> cyList=null;
		String sql="select * from category c inner join account a on c.aid=a.aid where c.ctype like ?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		DBConn dbconn=new DBConn();
		conn=dbconn.getConnection();
		try {
			cyList=new ArrayList<Category>();
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+ctype+"%");
			rs=ps.executeQuery();
			while(rs.next()){
				Category category=new Category();
				category.setCid(rs.getInt("cid"));
				category.setChot(rs.getBoolean("chot"));
				category.setCtype(rs.getString("ctype"));
				Account temp=new Account();
				temp.setAname(rs.getString("aname"));
				temp.setAid(rs.getInt("aid"));
				category.setAccount(temp);
				cyList.add(category);
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
		return cyList;
	}

	@Override
	public List<Category> queryCategory(boolean isChot) {
		// TODO Auto-generated method stub
		List<Category> chotList=null;
		String sql="select * from category c inner join account a on c.aid=a.aid where c.chot=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		DBConn dbconn=new DBConn();
		conn=dbconn.getConnection();
		try {
			chotList=new ArrayList<Category>();
			ps=conn.prepareStatement(sql);
			ps.setBoolean(1,isChot);
			rs=ps.executeQuery();
			while(rs.next()){
				Category category=new Category();
				category.setCid(rs.getInt("cid"));
				category.setChot(rs.getBoolean("chot"));
				category.setCtype(rs.getString("ctype"));
				Account temp=new Account();
				temp.setAname(rs.getString("aname"));
				temp.setAid(rs.getInt("aid"));
				category.setAccount(temp);
				chotList.add(category);
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
		return chotList;
	}
}