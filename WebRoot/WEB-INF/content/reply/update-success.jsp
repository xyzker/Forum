<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include flush="true" page="/forum/header.jsp"></jsp:include>


<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w">修改回复成功!</strong>
				</th>
			</tr>
		</table>
	</div>

	<div class="t t2">
		<table cellspacing="0" cellpadding="0" width="100%"
			style="table-layout:fixed;border-top:0">
			<tr class="tr1">
				<th style="text-align: center; line-height: 20px; ">
					<a href="<s:url action='list' namespace='/thread' />?thread.id=${reply.thread.id}">返回</a>
				</th>
			</tr>
		</table>
	</div>

	<jsp:include flush="true" page="/forum/footer.jsp" />