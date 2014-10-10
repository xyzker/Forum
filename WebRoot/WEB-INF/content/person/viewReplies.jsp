<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include flush="true" page="/forum/header.jsp"></jsp:include>
<script>
		if(window.name != "bencalie"){
   		 location.reload();
    		window.name = "bencalie";
		}
		else{
   		 window.name = "";
		}
</script>
<div id="main">
	<div class="t3" style="margin:8px auto">
		<table width="100%" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td>
					<strong class="fl w"> <img
							src="<%=basePath %>images/yellow/index/home_menu.gif" align="absmiddle"
							id="td_cate" onMouseOver="read.open('menu_cate','td_cate');"
							style="cursor:pointer;" />回复我的文章</strong>
				</td>
			</tr>
		</table>
	</div>

	<div class="c"></div>

	<div class="t3">
		<table width="100%" align="center" cellspacing="0" cellpadding="0">
			<tr>
				<td align="left" valign="middle">
					<div class="fl">
						<div class="pages">
							${ pagination }
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>


	<div class="t z" style="margin:3px auto">
		<table cellspacing="0" cellpadding="0" width="100%" id="ajaxtable">
			<tr>
				<th class="h" colspan="6">
					回复我的文章
				</th>
			</tr>
			<tbody style="table-layout:fixed;">
				<tr></tr>
				<tr class="tr2">
					<td class="tac y-style" style="width:12%">
						作者
					</td>
					<td style="width:60%" class="tac">
						标题
					</td>
					<td style="width:18%" class="y-style">
						回复时间
					</td>
					<td style="width:10%" class="y-style">
						查看原帖
					</td>
					
				</tr>


				<s:iterator id="reply" value="replyList">
					<tr align="center" class="tr3 t_one">
						<td class="tal y-style">
							<a
								href="<s:url action='viewPerson' namespace='/person'/>?person.id=${reply.author.id}"
								class="bl">${ reply.author.account }</a>
						</td>
						<td style="text-align:left;padding-left:8px;" id="td_579742">
							<h3>
								<a href="<s:url action='show' namespace='/reply'/>?reply.id=${reply.id}" style="color:blue">${
									reply.title }</a>
								<s:if test="#reply.read == false">
									<span style="color:red">(new!)</span>
								</s:if>
							</h3>
						</td>
						<td class="tal f10 y-style">
							<s:date name="#reply.dateCreated " format="yyyy-MM-dd  HH:mm:ss"/>
						</td>
						<td class="tal y-style">
							<a
								href="<s:url action='list' namespace='/thread'/>?thread.id=${reply.thread.id}"
								class="bl">查看</a>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="6" class="f_one" style="height:8px"></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="t3">
		<table cellspacing="0" cellpadding="0" width="100%" align="center">
			<tr valign="top">
				<td align="left">
					<div class="pages">
						${ pagination }
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>

<jsp:include flush="true" page="/forum/footer.jsp"></jsp:include>







