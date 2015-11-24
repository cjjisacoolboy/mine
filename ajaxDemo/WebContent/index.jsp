<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>ajaxdemo</title>
		<script type="text/javascript" src="js/jquery-1.11.1.min.js" ></script>
	</head>
	<body>
	 <%
	 	String account = (String)session.getAttribute("account");
	   if(account!=null){
		   out.print(account);
	   }else{
		   out.print("登录/注册");
	   }
	    
	 %>
	 <table>
	 	<tr>
	 	  <td>手机号：<input type="text" id="account" name="account" />
	    		<span id="msgDiv1"></span>
	    </td>
	 	</tr>
	 	<tr>
	 	  <td>
	 	    密码：<input type="text" id="password" name="password" />
	    	<span id="msgDiv2"></span>
	 	  </td>
	 	</tr>
	 	<tr>
	 	  <td><a id="submit" name="submit">登录</a></td>
	 	</tr>
	 </table>
	    <script type="text/javascript">
	    	$(function(){
	    	  $('#submit').click(function(){
	    		  $.ajax({
		    			type:"POST",
		    			url:"checkDup",
		    			data:{
		    				"account":$('#account').val(),
	    		  			"password":$('#password').val()
		    				},
		    			success:function(data){
		    				window.location.href = "index.jsp";
		    			}
		    		});
	    	  });
	    	});
	    </script>
	</body>
</html>