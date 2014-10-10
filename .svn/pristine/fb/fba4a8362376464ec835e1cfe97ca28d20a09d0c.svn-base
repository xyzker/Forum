<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include flush="true" page="/forum/header.jsp"></jsp:include>

<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w">添加版面</strong> &nbsp;
				</th>
			</tr>
		</table>
	</div>


	<s:form action="add" namespace="/board">
		<s:actionerror cssStyle="color:red"/>
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr3">
					<td style="width: 120px; ">
						类别:
					</td>
					<td>
						<s:select name="categoryId" list="categories" cssStyle="width: 200px; "
							listKey="id" listValue="name">
						</s:select>
					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px; ">
						名称:
					</td>
					<td>
						<s:textfield name="board.name" cssStyle="width: 200px; "></s:textfield>
					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px; ">
						描述:
					</td>
					<td>
						<s:textarea name="board.description"
							cssStyle="width: 200px; height: 50px; "></s:textarea>
					</td>
				</tr>

				<tr class="tr3">
					<td colspan="2">
						<s:submit cssClass="btn" value="添加" />
					</td>
				</tr>

			</table>
		</div>
	</s:form>

	<jsp:include flush="true" page="/forum/footer.jsp" />