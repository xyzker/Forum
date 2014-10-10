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
					<strong class="fl w">查看用户资料</strong> &nbsp;
				</th>
			</tr>
		</table>
	</div>

		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">


				<tr class="tr3">
					<td style="width: 120px; ">
						帐号:
					</td>
					<td>
						<s:property value="person.account"/>
					</td>
				</tr>
				<tr class="tr3">
					<td>
						姓名:
					</td>
					<td>
						<s:property value="person.name"/> &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						性别:
					</td>
					<td>
						<s:property value="person.sex"/> &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						电子邮件:
					</td>
					<td>
						<s:property value="person.email"/> &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						生日:
					</td>
					<td>
						<s:property value="person.birthday"/> &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						注册时间:
					</td>
					<td>
						<s:date name="person.dateCreated" format="yyyy-MM-dd  HH:mm:ss"/> &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						上次登录时间:
					</td>
					<td>
						<s:date name="person.dateLastActived" format="yyyy-MM-dd  HH:mm:ss"/> &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						负责的版面:
					</td>
					<td>
						<s:iterator value="person.boardsAdministrated" id="board">
							<a href="<s:url action='list' namespace='/board' />?board.id=${board.id}"><s:property value="name"/></a>
						</s:iterator>
						&nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						头像:
					</td>
					<td>
						<img class="pic"
							src="<%=basePath %>images/avatar/${person.account}.jpg" 
							onerror="javascript:this.src='<%=basePath %>images/avatar/default.jpg'"
							width="100" height="100" border="0" /> &nbsp;
		<s:if test="#session.user.id == person.id">
			<a href="<s:url action='addAvatar-input' namespace='/person'/>?person.id=${person.id}">修改头像</a>
	  	</s:if>
					</td>
				</tr>
			</table>
		</div>

<jsp:include flush="true" page="/forum/footer.jsp" />