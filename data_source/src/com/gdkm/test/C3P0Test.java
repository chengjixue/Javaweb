package com.gdkm.test;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
//C3P0数据源手动设置数据库配置属性，直接创建数据源对象
public class C3P0Test {
	public static DataSource ds = null;
	// 初始化C3P0数据源
	static {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		// 设置连接数据库需要的配置信息
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/javawebdb");
			cpds.setUser("root");
			cpds.setPassword("root");
			// 设置连接池的参数
			cpds.setInitialPoolSize(5);
			cpds.setMaxPoolSize(15);
			ds = cpds;
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static void main(String[] args) throws SQLException {
		// 获取数据库连接对象
		System.out.println(ds.getConnection());
		// 获取数据库连接对象
		Connection conn = ds.getConnection();
		//获取数据库连接信息
		DatabaseMetaData metaData = conn.getMetaData();
		//打印数据库连接信息
        System.out.println(metaData.getURL()
              +",UserName="+metaData.getUserName() +","+metaData.getDriverName());			
	}
}
