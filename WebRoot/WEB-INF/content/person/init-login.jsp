<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include flush="true" page="/forum/header.jsp"></jsp:include>
<div id="main">

	<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w">”√ªßµ«¬º</strong> &nbsp;
					<span style="color: red; font-weight: bold; ">${message }</span>
				</th>
			</tr>
		</table>
	</div>

	<s:form action="login" namespace="/person">
		<s:actionerror cssStyle="color:red"/>
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr3">
					<td style="width: 120px; ">
						’ ∫≈:
					</td>
					<td>
						<s:textfield name="person.account"></s:textfield>
					</td>
				</tr>

				<tr class="tr3">
					<td style="width: 120px; ">
						√‹¬Î:
					</td>
					<td>
						<s:password name="person.password"></s:password>
					</td>
				</tr>

				<tr class="tr3">
					<td colspan="2">
						<s:submit cssClass="btn" value="µ«¬º" />
					</td>
				</tr>
			</table>
		</div>
	</s:form>
	
	<div class="t t2">
		<table cellspacing="0" cellpadding="0" width="100%"
			style="table-layout:fixed;border-top:0">
			<tr class="tr1">
				<th style="text-align: center; line-height: 20px; ">
					<a href="javascript:window.history.go(-1);">∑µªÿ</a>
				</th>
			</tr>
		</table>
	</div>

	<jsp:include flush="true" page="/forum/footer.jsp" />