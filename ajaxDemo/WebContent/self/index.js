/* 以支持多种浏览器的方式创建 XMLHttpRequest 对象  */
//1、建立一个变量 xmlHttp 来引用即将创建的 XMLHttpRequest 对象。
    var xmlHttp = false;
/*2、尝试在 Microsoft 浏览器中创建该对象： 
  1）尝试使用 Msxml2.XMLHTTP 对象创建它。 
  2）如果失败，再尝试 Microsoft.XMLHTTP对象。*/
/*@cc_on @*/
/*@if (@_jscript_version >= 5)				
try {
  xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
} catch (e) {
  try {
    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  } catch (e2) {
    xmlHttp = false;
  }
}
@end @*/

//3、如果仍然没有建立 xmlHttp，则以非 Microsoft 的方式创建该对象。
	if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
	  xmlHttp = new XMLHttpRequest();
	}
	
	//后台业务完成后，到这里来处理数据
	function ajaxcallback () {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			//获取后台传递过来的消息
			var message = xmlHttp.responseText;
			document.getElementById('msgDiv').innerHTML = message;
		}
	}
	
	function checkDup () {
		//从文本框中获取用户输入的文本
		var text = document.getElementById('account').value;
		//document.getElementById('msgDiv').innerHTML = text;
		//这个url可以是一个jsp,servlet或者action
		var url = 'checkDup';
		var data = 'text=' + text;
		//实际上往后台提交的请求路径：
		//http://localhost:8080/ajaxDemo/checkDup?text=a
		//传多个参数时，ajax提交的url
		//var data = 'param1=a&param2=b&param3=11';
		//http://localhost:8080/ajaxDemo/checkDup?param1=a&param2=b&param3=11
		//将用户输入的文本传到后台去
		if (xmlHttp) {
			//打开服务器连接
			xmlHttp.open('post',url,true);
			//设置后台处理完成后重返本页面需要调用的js函数（回调函数）
			//使用已定义的函数（方法一）
			xmlHttp.onreadystatechange = ajaxcallback;
			//使用匿名函数定义（方法二）
			//如果需要传参数，用这个方法比较好
			//xmlHttp.onreadystatechange = function (){};
			//设置请求头
			xmlHttp.setRequestHeader("content-type"
					,"application/x-www-form-urlencoded");
			//发送请求
			xmlHttp.send(data);
		}
	}
	
	
	
	
	
	
	
	
	