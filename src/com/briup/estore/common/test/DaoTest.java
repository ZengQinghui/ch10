package com.briup.estore.common.test;

import java.util.List;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerDao;

public class DaoTest {
	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDao();
		//customerDao.save(new Customer(null, "张三", "123321", 12, "18898761234"));
		//customerDao.deleteById(20);
		//System.out.println(customerDao.findById(18));
		//System.out.println(cus.getPassword());
		//customerDao.update(new Customer(null, "1", "1", 12, null));
		/* for(int i=0;i<customerDao.findById(18).size();i++){
			System.out.println(customerDao.findById(18).get(i));
		}  */
		customerDao.update("李四", 19);
	}
	
	
}
