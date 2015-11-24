package com.icss.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckDupServlet
 */
public class CheckDupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取前台传递过来的用户输入的文本text
		String account = request.getParameter("account");
		System.out.println(account);
		String password = request.getParameter("password");
		System.out.println(password);
		String message = "登录失败";
		//进行重名验证
		//连接数据库进行验证
		if ("admin".equals(account)) {
			message = "登录成功";
			request.getSession().setAttribute("account", account);
			
		}
		System.out.println("显示的信息是：" + message);
		//把message回写到前台
		//乱码处理
		response.setCharacterEncoding("utf-8");
		//可以在回调函数中使用xmlHttp.responseText的方式获取
		response.getWriter().write(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
