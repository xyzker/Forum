<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include flush="true" page="/forum/header.jsp"></jsp:include>

<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w">上传头像</strong> &nbsp;
				</th>
			</tr>
		</table>
	</div>

		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<s:fielderror cssStyle="color:red"></s:fielderror>
			<s:form action="addAvatar" namespace="/person" enctype="multipart/form-data" method="post">
	  			<s:hidden name="person.id" value="%{person.id}"></s:hidden>
	  			<s:file name="avatar" label="选择头像"></s:file>
	  			<s:submit value="上传头像"></s:submit>(2M以下的jpg文件)
	  		</s:form>
					</td>
				</tr>
			</table>
		</div>

<jsp:include flush="true" page="/forum/footer.jsp" />