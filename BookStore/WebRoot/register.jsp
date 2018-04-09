<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/js.js"></script>

<title>bookStore注册页面</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript">
	function changeImage() {

		document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
				+ new Date().getTime();
	}
</script>s
<script type="text/javascript">
function ckemail(){
 	var email =document.getElementsByName("email")[0];	
 	var req =createXMLHttpRequest();
 	 req.onreadystatechange = function(){
 	if(req.readyState==4 && req.status==200){
 			var x = document.getElementById("email_font");
 		if(req.responseText=="false"){
 			//alert(req.responseText);
 			x.innerHTML="输入的邮箱非法";
 			x.color="red";
 		}else{
 			//alert(req.responseText);
 			x.innerHTML="输入的邮箱可用";
 			x.color="green";		}
 	}
 	};
 	req.open("get","${pageContext.request.contextPath }/emailservlet?email="+email.value);
 	req.send(null);
 	}
function vkname(){
 	var username =document.getElementsByName("username")[0];	
 	var req =createXMLHttpRequest();
 	 req.onreadystatechange = function(){
 	if(req.readyState==4 && req.status==200){
 			var x = document.getElementById("user_font");
 			
 		if(req.responseText=="1"){
 			//alert(req.responseText);
 			x.innerHTML="输入的用户名可用";
 			x.color="green";
 		}else {
 			//alert(req.responseText);
 			x.innerHTML="输入的用户名非法";
 			x.color="red";		}
 	}
 	};
 	req.open("get","${pageContext.request.contextPath }/usernameservlet?username="+username.value);
 	req.send(null);
 	}

</script>
</head>


<body class="main">
	<%@include file="head.jsp"%>
	<%--导入头 --%>
	<%@include file="menu_search.jsp"%><%--导入导航条与搜索 --%>

	<div id="divcontent">
		<form action="${pageContext.request.contextPath}/Register"
			method="post">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px">
						<h1>新会员注册${reg_msg}</h1>

						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">会员邮箱：</td>
								<td style="width:40%"><input type="text" class="textinput"
									name="email"  onblur="ckemail()"/></td>
								<td><font color="#999999" id="email_font">请输入有效的邮箱地址</font></td>
							</tr>
							<tr>
								<td style="text-align:right">会员名：</td>
								<td><input type="text" class="textinput" name="username" onblur="vkname()"/>
								</td>
								<td><font color="#999999" id="user_font">用户名设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">密码：</td>
								<td><input type="password" class="textinput"
									name="password" /></td>
								<td><font color="#999999">密码设置至少6位</font></td>
							</tr>
							<tr>
								<td style="text-align:right">重复密码：</td>
								<td><input type="password" class="textinput"
									name="repassword" /></td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td style="text-align:right">性别：</td>
								<td colspan="2">&nbsp;&nbsp;<input type="radio"
									name="gender" value="男" checked="checked" /> 男
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
									name="gender" value="女" /> 女</td>
							</tr>
							<tr>
								<td style="text-align:right">联系电话：</td>
								<td colspan="2"><input type="text" class="textinput"
									style="width:350px" name="telephone" /></td>
							</tr>
							<tr>
								<td style="text-align:right">个人介绍：</td>
								<td colspan="2"><textarea class="textarea" name="introduce"></textarea>
								</td>
							</tr>

						</table>



						<h1>注册校验</h1>
						<table width="80%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align:right; width:20%">输入校验码：</td>
								<td style="width:50%"><input type="text" class="textinput"
									name="code" />
								</td>
								<td>${code_msg }</td>
							</tr>
							<tr>
								<td style="text-align:right;width:20%;">&nbsp;</td>
								<td colspan="2" style="width:50%"><img
									src="${pageContext.request.contextPath}/imageCode" width="180"
									height="30" class="textinput" style="height:30px;" id="img" />&nbsp;&nbsp;
									<a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
								</td>
							</tr>
						</table>



						<table width="70%" border="0" cellspacing="0">
							<tr>
								<td style="padding-top:20px; text-align:center"><input
									type="image" src="images/signup.gif" name="submit" border="0">
								</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</div>



	<div id="divfoot">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td rowspan="2" style="width:10%"><img
					src="images/bottomlogo.gif" width="195" height="50"
					style="margin-left:175px" /></td>
				<td style="padding-top:5px; padding-left:50px"><a href="#"><font
						color="#747556"><b>CONTACT US</b> </font> </a></td>
			</tr>
			<tr>
				<td style="padding-left:50px"><font color="#CCCCCC"><b>COPYRIGHT
							2008 &copy; eShop All Rights RESERVED.</b> </font></td>
			</tr>
		</table>
	</div>


</body>
</html>
