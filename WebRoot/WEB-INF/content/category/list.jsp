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
<div class="contentwrap z">
	<s:iterator value="categories" id="category">
		<div class="t">
			<table cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<th class="h" colspan="6">
						<a class="closeicon fr" style="cursor:pointer;"
							onclick="return IndexDeploy('85',0)"><img id="img_85"
								src="<%=basePath%>images/yellow/index/cate_fold.gif" /> </a>
						<h2>
							&raquo;
							<a href="<s:url action='viewCategory' namespace='/category' />?category.id=${category.id}"
								class="cfont"><s:property value="name"/></a>
						</h2>
					</th>
				</tr>
				<tr></tr>
				<tr class="tr2">
					<td width="*" colspan="2" class="tac">
						论坛
					</td>
					<td class="tal y-style e" style="width:5%">
						主题
					</td>
					<td class="tal y-style e" style="width:5%">
						文章
					</td>
					<td class="tal y-style f" style="width:40%">
						最后发表
					</td>
					<td class="y-style" style="width:10%">
						版主
					</td>
				</tr>
				<tbody id="cate_85" style="display:;">
					<s:iterator value="#category.boards" id="board">
						<tr class="tr3 f_one">
							<td class="icon tac" width="45">
								<a
									href="<s:url action='list' namespace='/board' />?board.id=${board.id}">
									<img src="../images/yellow/new.gif" /> </a>
							</td>
							<th>
								<h3 class="b">
									<a
										href="<s:url action='list' namespace='/board' />?board.id=${board.id}">${
										board.name }</a>
								</h3>
								<br />
								<span class="smalltxt gray">${ board.description }</span>
							</th>
							<td class="tal y-style e">
								<span class="f10">${ board.threadCount }</span>
								<br />
							</td>
							<td class="tal y-style e">
								<span class="f10">${ board.replyCount }</span>
								<br />
							</td>
							<th>
								<s:if test="#board.lastThread != null">
									<a
										href="<s:url action='list' namespace='/thread'/>?thread.id=${board.lastThread.id}"
										class="a2">${ board.lastThread.title }</a>
									<br />
									<span class="f12"><a
										href="<s:url action='viewPerson' namespace='/person'/>?person.id=${board.lastThread.author.id}">${
											board.lastThread.author.account }</a> </span>&nbsp;&nbsp;
									<span class="f9 gray"><s:date name="#board.lastThread.dateCreated" format="yyyy-MM-dd  HH:mm:ss"/></span>
								</s:if>
								<s:if test="#board.lastReply != null ">
									<a
										href="<s:url action='list' namespace='/thread'/>?thread.id=${board.lastReply.thread.id}"
										class="a2">${ board.lastReply.title }</a>
									<br />
									<span class="f12"><a
										href="<s:url action='viewPerson' namespace='/person'/>?person.id=${board.lastReply.author.id}">${
											board.lastReply.author.account }</a> </span>&nbsp;&nbsp;
									<span class="f9 gray"><s:date name="#board.lastReply.dateCreated" format="yyyy-MM-dd  HH:mm:ss"/></span>
								</s:if>
								&nbsp;
							</th>
							<td class="y-style"
								style="word-break: keep-all;word-wrap:no-wrap">
								<s:iterator value="#board.administrators" id="person">
									<a
										href="<s:url action='viewPerson' namespace='/person'/>?person.id=<s:property value='#person.id'/>"><s:property value="#person.account"/></a>
								</s:iterator>
								&nbsp;
							</td>
						</tr>
					</s:iterator>
					<tr>
						<td class="f_one" colspan="6" style="height:8px"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</s:iterator>
</div>

<jsp:include flush="true" page="/forum/footer.jsp"></jsp:include>







