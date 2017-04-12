package com.xy9860.shopping.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.xy9860.shopping.pojo.Sorder;

public interface ISorder {
	public void saveSorder(Sorder sorder,int fid,Connection conn) throws SQLException;
}
