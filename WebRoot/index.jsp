<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>北邮人小论坛</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h1>北邮人小论坛</h1>
  	<a href="<s:url action='list' namespace='/category' />">由此进入</a><br>
  <h4>快速入口</h4>
    <a href="<s:url action='init-add' namespace='/person' />">用户注册</a><br>
    <a href="<s:url action='init-login' namespace='/person'/>">用户登陆</a><br>
    <a href="<s:url action='logout' namespace='/person' />">用户注销</a><br>
    <a href="<s:url action='viewPerson' namespace='/person'/>?person.id=5">浏览用户信息（xyzker）</a><br>
   	<a href="<s:url action='viewReplies' namespace='/person'/>?person.id=5">查看回复用户的文章（xyzker）</a><br>
    <a href="<s:url action='list' namespace='/category' />">浏览类别</a><br>
    <a href="<s:url action='init-add' namespace='/category'/>">添加类别</a><br>
    <a href="<s:url action='viewCategory' namespace='/category' />?category.id=6">浏览特定类别（生活时尚）</a><br>
    <a href="<s:url action='list' namespace='/board' />?board.id=4">浏览版面（情感的天空）</a><br>
    <a href="<s:url action='init-add' namespace='/board'/>">添加版面</a><br>
    <a href="<s:url action='init-setAdmin' namespace='/board'/>?board.id=4">设置版主</a><br>
    <a href="<s:url action='init-add' namespace='/thread'/>?board.id=4">发表帖子（情感的天空）</a><br>
    <a href="<s:url action='list' namespace='/thread'/>?thread.id=10">浏览帖子（想回到学校）</a><br>
    <a href="<s:url action='init-add' namespace='/reply'/>?thread.id=10">回复帖子（想回到学校）</a><br>
    <a href="<s:url action='init-update' namespace='/reply'/>?reply.id=42">修改回复（昨天是你生日2楼）</a><br>
  	<a href="<s:url action='init-update' namespace='/thread'/>?thread.id=26">修改帖子（昨天是你生日）</a><br>
  	<a href="<s:url action='init-addChild' namespace='/reply'/>?reply.id=59">回复回复（可以上传了？）</a>
  </body>
</html>
