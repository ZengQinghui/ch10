package com.briup.estore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.briup.estore.bean.Customer;
import com.briup.estore.common.jdbc.ConnectionFactory;

/**
 * 数据访问层Dao
 * 
 * 增删改查，没有业务逻辑的处理
 * */
public class CustomerDao {
	/**
    */
	public CustomerDao() {
		
	}

	/**
	 * @param customer
	 * @roseuid 56F9D35B03BE
	 */
	public void save(Customer customer) {
		try {
			Connection conn = null;
			PreparedStatement pstmt = null;
			try{
				//注册驱动，获取连接
				conn= ConnectionFactory.getConn();
				
				String sql = "insert into customer"
						+ "(name,password,age,telephone)"
						+ " values(?,?,?,?)";
				//创建pstmt,如果有占位符，替换占位符
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, customer.getName());
				pstmt.setString(2, customer.getPassword());
				pstmt.setInt(3, customer.getAge());
				pstmt.setString(4, customer.getTelephone());
				//执行sql executeUpdate(add delete update)  executeQuery (query)
				pstmt.executeUpdate();
			}finally{
				ConnectionFactory.close(null, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @return com.briup.estore.bean.Customer
	 * @roseuid 56F9D8420323
	 */
	public Customer findById(long id) {
		return null;
	}

	/**
	 * @param customer
	 * @roseuid 56F9D8810163
	 */
	public void update(Customer customer) {

	}

	/**
	 * @param id
	 * @roseuid 56F9D89603B0
	 */
	public void deleteById(long id) {

	}
}
