 package com.gdkm.test;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
 
//C3PO数据源通过读取配置文件方式，获取数据库的配置信息，创建数据源对象
 public class C3P0Test2 {
 	public static DataSource ds = null;
 	// 初始化C3P0数据源
 	static {
 		ComboPooledDataSource cpds = new ComboPooledDataSource();
 		// 使用c3p0-config.xml配置文件中的named-config节点中name属性的值，如果没有则使用默认配置
// 		ComboPooledDataSource cpds = new ComboPooledDataSource("c3p0ds");
 		ds = cpds;
 	}
 	public static void main(String[] args) throws SQLException {
 		System.out.println(ds.getConnection());
		// 获取数据库连接对象
		Connection conn = ds.getConnection();
		//获取数据库连接信息
		DatabaseMetaData metaData = conn.getMetaData();
		//打印数据库连接信息
		System.out.println(metaData.getURL()
             +",UserName="+metaData.getUserName()+","+metaData.getDriverName());
 	}
 }
