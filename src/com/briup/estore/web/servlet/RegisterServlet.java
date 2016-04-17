package com.briup.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;
//http://localhost:8080/ch10/register.jsp
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ICustomerService customerService;   
    public RegisterServlet() {
        super();
        customerService = new CustomerServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//2.获取参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String telephone = request.getParameter("telephone");
		//3.调用业务逻辑service层代码完成业务逻辑
		Customer customer = new Customer(null, name, password, age, telephone);
		customerService.register(customer);
		//4.页面跳转
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/success.jsp").forward(request, response);
		
	}

}
