package com.xy9860.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.xy9860.shopping.dao.ISorder;
import com.xy9860.shopping.pojo.Sorder;

public class SorderImpl implements ISorder {

	@Override
	public void saveSorder(Sorder sorder, int fid, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps= conn.prepareStatement("INSERT INTO sorder VALUE(null,?,?,?,?,?)");
		ps.setString(1, sorder.getSname());
		ps.setDouble(2, sorder.getSprice());
		ps.setInt(3, sorder.getSnumber());
		ps.setInt(4, fid);
		ps.setInt(5, sorder.getGoods().getGid());
		ps.executeUpdate();
	}

}
