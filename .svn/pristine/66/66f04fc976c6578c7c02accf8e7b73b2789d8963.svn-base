<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include flush="true" page="/forum/header.jsp"></jsp:include>

<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w"><b>添加类别</b></strong>
				</th>
			</tr>
		</table>
	</div>

	<s:form action="add" namespace="/category">
		<s:actionerror cssStyle="color:red"/>
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr1 r_one">
					<th style="width:20%" class="r_two"  style="text-align: right">
						名称
					</th>
					<th style="vertical-align:bottom;padding-left:15px;border:0">
						<s:textfield name="category.name"></s:textfield>
						<br/><br/>
						<s:submit value="提交" cssClass="btn"></s:submit>
					</th>
				</tr>
			</table>
		</div>
	</s:form>

	<jsp:include flush="true" page="/forum/footer.jsp" />