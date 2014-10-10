<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include flush="true" page="/forum/header.jsp"></jsp:include>

<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w">设置版主</strong> &nbsp;
					<span style="color: red; font-weight: bold; ">${
						exception.message }</span>
				</th>
			</tr>
		</table>
	</div>

	<s:form action="setAdmin" namespace="/board">
		<s:hidden name="board.id" value="%{board.id}"></s:hidden>
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr3">
					<td style="width: 120px; ">
						版面名称:
					</td>
					<td>
						${ board.name } &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px; ">
						版面描述:
					</td>
					<td>
						${ board.description } &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px; ">
						版主:
					</td>
					<td>
						<s:checkboxlist list="persons" name="admins" listKey="id" 
						listValue="account"></s:checkboxlist>
					</td>
				</tr>

				<tr class="tr3">
					<td colspan="2">
						<s:submit cssClass="btn" value="保存" />
					</td>
				</tr>

			</table>
		</div>
	</s:form>


	<jsp:include flush="true" page="/forum/footer.jsp" />