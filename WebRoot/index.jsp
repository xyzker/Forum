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
    
    <title>������С��̳</title>
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
  <h1>������С��̳</h1>
  	<a href="<s:url action='list' namespace='/category' />">�ɴ˽���</a><br>
  <h4>�������</h4>
    <a href="<s:url action='init-add' namespace='/person' />">�û�ע��</a><br>
    <a href="<s:url action='init-login' namespace='/person'/>">�û���½</a><br>
    <a href="<s:url action='logout' namespace='/person' />">�û�ע��</a><br>
    <a href="<s:url action='viewPerson' namespace='/person'/>?person.id=5">����û���Ϣ��xyzker��</a><br>
   	<a href="<s:url action='viewReplies' namespace='/person'/>?person.id=5">�鿴�ظ��û������£�xyzker��</a><br>
    <a href="<s:url action='list' namespace='/category' />">������</a><br>
    <a href="<s:url action='init-add' namespace='/category'/>">�������</a><br>
    <a href="<s:url action='viewCategory' namespace='/category' />?category.id=6">����ض��������ʱ�У�</a><br>
    <a href="<s:url action='list' namespace='/board' />?board.id=4">������棨��е���գ�</a><br>
    <a href="<s:url action='init-add' namespace='/board'/>">���Ӱ���</a><br>
    <a href="<s:url action='init-setAdmin' namespace='/board'/>?board.id=4">���ð���</a><br>
    <a href="<s:url action='init-add' namespace='/thread'/>?board.id=4">�������ӣ���е���գ�</a><br>
    <a href="<s:url action='list' namespace='/thread'/>?thread.id=10">������ӣ���ص�ѧУ��</a><br>
    <a href="<s:url action='init-add' namespace='/reply'/>?thread.id=10">�ظ����ӣ���ص�ѧУ��</a><br>
    <a href="<s:url action='init-update' namespace='/reply'/>?reply.id=42">�޸Ļظ���������������2¥��</a><br>
  	<a href="<s:url action='init-update' namespace='/thread'/>?thread.id=26">�޸����ӣ������������գ�</a><br>
  	<a href="<s:url action='init-addChild' namespace='/reply'/>?reply.id=59">�ظ��ظ��������ϴ��ˣ���</a>
  </body>
</html>