package com.xy9860.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xy9860.shopping.dao.IGoods;
import com.xy9860.shopping.pojo.Category;
import com.xy9860.shopping.pojo.Goods;
import com.xy9860.shopping.util.DBConn;

public class GoodsImpl implements IGoods {

	@Override
	public List<Goods> queryGoods(Goods goods) {
		List<Goods> gdList=null;
		String sql=" select * from goods g inner join category c on g.cid=c.cid  where g.gname like ? and g.gremark like ?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		DBConn dbconn=new DBConn();
		conn=dbconn.getConnection();
		try {
			gdList=new ArrayList<Goods>();
			ps=conn.prepareStatement(sql);
			ps.setString(1,"%"+goods.getGname()+"%");
			ps.setString(2,"%"+goods.getGremark()+"%");
			rs=ps.executeQuery();
			while(rs.next()){
				Goods g=new Goods();
				g.setGid(rs.getInt("gid"));
				g.setGname(rs.getString("gname"));
				g.setGprice(rs.getDouble("gprice"));
				g.setGpic(rs.getString("gpic"));
				g.setGremark(rs.getString("gremark"));
				g.setGxremark(rs.getString("gxremark"));
				g.setGdate(rs.getString("gdate"));
				g.setGiscommend(rs.getBoolean("giscommend"));
				g.setGisopen(rs.getBoolean("gisopen"));
				Category c=new Category();
				c.setCid(rs.getInt("cid"));
				c.setCtype(rs.getString("ctype"));
				g.setCategory(c);
				gdList.add(g);
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
		return gdList;
	}

	@Override
	public void saveGoods(Goods goods) {
		// TODO Auto-generated method stub
		String sql="insert into goods values(null,?,?,?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement ps=null;
		DBConn dbconn=new DBConn();
		conn=dbconn.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, goods.getGname());
			ps.setDouble(2, goods.getGprice());
			ps.setString(3, goods.getGpic());
			ps.setString(4, goods.getGremark());
			ps.setString(5, goods.getGxremark());
			ps.setString(6, null);
			ps.setBoolean(7, goods.isGiscommend());
			ps.setBoolean(8, goods.isGisopen());
			ps.setInt(9, goods.getCategory().getCid());
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
	public List<Goods> queryChotGoods(Category c) {
		// TODO Auto-generated method stub
		List<Goods> gdList=null;
		String sql="select * from goods g inner join category c on g.cid=c.cid  where g.cid=? AND g.giscommend=TRUE AND g.gisopen=TRUE ORDER by gdate DESC";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		DBConn dbconn=new DBConn();
		conn=dbconn.getConnection();
		try {
			gdList=new ArrayList<Goods>();
			ps=conn.prepareStatement(sql);
			ps.setInt(1,c.getCid());
			rs=ps.executeQuery();
			while(rs.next()){
				Goods g=new Goods();
				g.setGid(rs.getInt("gid"));
				g.setGname(rs.getString("gname"));
				g.setGprice(rs.getDouble("gprice"));
				g.setGpic(rs.getString("gpic"));
				g.setGremark(rs.getString("gremark"));
				g.setGxremark(rs.getString("gxremark"));
				g.setGdate(rs.getString("gdate"));
				g.setGiscommend(rs.getBoolean("giscommend"));
				g.setGisopen(rs.getBoolean("gisopen"));
				Category c1=new Category();
				c1.setCid(rs.getInt("cid"));
				c1.setCtype(rs.getString("ctype"));
				g.setCategory(c1);
				gdList.add(g);
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
		return gdList;
	}


}
