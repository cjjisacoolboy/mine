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
		//��ȡǰ̨���ݹ������û�������ı�text
		String account = request.getParameter("account");
		System.out.println(account);
		String password = request.getParameter("password");
		System.out.println(password);
		String message = "��¼ʧ��";
		//����������֤
		//�������ݿ������֤
		if ("admin".equals(account)) {
			message = "��¼�ɹ�";
			request.getSession().setAttribute("account", account);
			
		}
		System.out.println("��ʾ����Ϣ�ǣ�" + message);
		//��message��д��ǰ̨
		//���봦��
		response.setCharacterEncoding("utf-8");
		//�����ڻص�������ʹ��xmlHttp.responseText�ķ�ʽ��ȡ
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
