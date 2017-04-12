package com.xy9860.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import com.xy9860.shopping.dao.IForder;
import com.xy9860.shopping.dao.ISorder;
import com.xy9860.shopping.pojo.Forder;
import com.xy9860.shopping.pojo.Sorder;
import com.xy9860.shopping.util.DBConn;

public class ForderImpl implements IForder {

	private ISorder sorderImpl=new SorderImpl();
	
	@Override
	public Forder addSorder(Forder forder,Sorder sorder) {
		// TODO Auto-generated method stub
		Set<Sorder> sorders= forder.getSorders();
		Iterator<Sorder> iterator=sorders.iterator();
		boolean flag=false;
		while (iterator.hasNext()) {
			Sorder temp=iterator.next();
			if(temp.getGoods().getGid()==sorder.getGoods().getGid()){
				temp.setSnumber(temp.getSnumber()+1);
				flag=true;
			}
		}
		if(!flag){
			sorders.add(sorder);
		}
		//更新商品时进行计算购物总价
		forder.setFtotal(this.cluTotal(forder));
		return forder;
	}

	@Override
	public double cluTotal(Forder forder) {
		// TODO Auto-generated method stub
		double total=0.0;
		for(Sorder temp:forder.getSorders()){
			total+=temp.getSprice()*temp.getSnumber();
		}
		return total;
	}

	@Override
	public Forder delSorder(Forder forder, int gid) {
		// TODO Auto-generated method stub
		Set<Sorder> sorders= forder.getSorders();
		Iterator<Sorder> iterator=sorders.iterator();
		while (iterator.hasNext()) {
			Sorder temp=iterator.next();
			if(temp.getGoods().getGid()==gid){
				iterator.remove();
			}
		}
		//更新商品时进行计算购物总价
		forder.setFtotal(this.cluTotal(forder));
		return forder;
	}

	@SuppressWarnings("resource")
	@Override
	public Forder saveForder(Forder forder) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO forder VALUES(NULL,NULL,?,?,?,?,?,?,?,?,NULL,?)";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		DBConn dbconn=new DBConn();
		conn=dbconn.getConnection();
		try {
			//设置事务不自动提交.默认为true
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(sql);
			ps.setDouble(1, forder.getFtotal());
			ps.setString(2, forder.getFname());
			ps.setString(3, forder.getFphone());
			ps.setString(4, forder.getFremark());
			ps.setString(5, forder.getFemail());
			ps.setString(6, forder.getFaddress());
			ps.setString(7, forder.getFpost());
			ps.setInt(8, forder.getUsers().getUid());
			ps.setInt(9, 1);//设置状态为未支付
			ps.executeUpdate();
			//查询刚才插入的订单的主键
			ps=conn.prepareStatement("SELECT LAST_INSERT_ID() id");
			rs=ps.executeQuery();
			if (rs.next()) {
				forder.setFid(rs.getInt("id"));
			}
			//由于使用一个事务,所以使用同一个connection
			for (Sorder temp : forder.getSorders()) {
				sorderImpl.saveSorder(temp, forder.getFid(), conn);
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		return forder;
	}

}
