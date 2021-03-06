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
							style="cursor:pointer;" /> <a
						href="<s:url action='viewCategory' namespace='/category' />?category.id=${board.category.id}">${
							board.category.name }</a> &raquo; <a
						href="<s:url action='list' namespace='/board' />?board.id=${board.id}">${
							board.name }</a> </strong>
					<div class="fr w">
						<a
							href="<s:url action='init-setAdmin' namespace='/board'/>?board.id=${board.id}">版主</a>:
						&nbsp;
						<s:iterator value="board.administrators" id="person">
							<a href="<s:url action='viewPerson' namespace='/person'/>?person.id=<s:property value='#person.id'/>"><s:property value="#person.account"/></a>
						</s:iterator>
					</div>
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
				<td style="text-align:right">
					<a
						href="<s:url action='init-add' namespace='/thread'/>?board.id=${board.id}"><img
							src="<%=basePath %>images/yellow/post.png" id="td_post" /> </a>
				</td>
			</tr>
		</table>
	</div>


	<div class="t z" style="margin:3px auto">
		<table cellspacing="0" cellpadding="0" width="100%" id="ajaxtable">
			<tr>
				<th class="h" colspan="6">
					<a
						href="<s:url action='list' namespace='/board' />?board.id=${board.id}">${
						board.name }</a>
				</th>
			</tr>
			<tbody style="table-layout:fixed;">
				<tr></tr>
				<tr class="tr2">
					<td class="tac y-style">
						状态
					</td>
					<td style="width:50%" class="tac">
						文章
					</td>
					<td style="width:17%" class="y-style">
						作者
					</td>
					<td style="width:6%" class="y-style">
						回复
					</td>
					<td style="width:6%" class="y-style">
						人气
					</td>
					<td style="width:17%" class="y-style">
						最后回复
					</td>
				</tr>


				<s:iterator id="thread" value="threadList">

					<tr align="center" class="tr3 t_one">
						<td>
							<a title="打开新窗口"
								href="<s:url action='list' namespace='/thread'/>?thread.id=${thread.id}"
								target="_blank"><img src="<%=basePath %>images/yellow/thread/topichot.gif"
									border=0> </a>
						</td>
						<td style="text-align:left;padding-left:8px" id="td_579742">
							<h3>
								<a
									href="<s:url action='list' namespace='/thread'/>?thread.id=${thread.id}">${
									thread.title }</a>
							</h3>
						</td>
						<td class="tal y-style">
							<a
								href="<s:url action='viewPerson' namespace='/person'/>?person.id=${thread.author.id}"
								class="bl">${ thread.author.account }</a>
							<div class="f10">
								<s:date name="#thread.dateCreated " format="yyyy-MM-dd  HH:mm:ss"/>
							</div>
						</td>
						<td class="tal f10 y-style">
							${ thread.replyCount }
						</td>
						<td class="tal f10 y-style">
							${ thread.hit }
						</td>
						<td class="tal y-style">
							&nbsp;
							<s:if test="#thread.authorLastReplied != null ">
								<a
									href="<s:url action='viewPerson' namespace='/person'/>?person.id=${thread.authorLastReplied.id}"
									class="bl">${ thread.authorLastReplied.account }</a>
								<div class="f10">
									<s:date name="#thread.dateLastReplied" format="yyyy-MM-dd  HH:mm:ss"/>
								</div>
							</s:if>
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
				<td style="text-align:right;padding-top:5px">
					<a
						href="<s:url action='init-add' namespace='/thread'/>?board.id=${board.id}"><img
							src="<%=basePath %>images/yellow/post.png" id="td_post" /> </a>
				</td>
			</tr>
		</table>
	</div>
</div>

<jsp:include flush="true" page="/forum/footer.jsp"></jsp:include>







