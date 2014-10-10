<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include flush="true" page="/forum/header.jsp"></jsp:include>

<!-- TinyMCE -->
<script type="text/javascript" src="<%=basePath %>tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
	tinyMCE.init({
		// General options
		mode : "textareas",
		theme : "advanced",
		plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave,visualblocks",

		// Theme options
		theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft,visualblocks",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : true,

		// Example content CSS (should be your site CSS)
		content_css : "css/content.css",

		// Drop lists for link/image/media/template dialogs
		template_external_list_url : "lists/template_list.js",
		external_link_list_url : "lists/link_list.js",
		external_image_list_url : "lists/image_list.js",
		media_external_list_url : "lists/media_list.js",

		// Style formats
		style_formats : [
			{title : 'Bold text', inline : 'b'},
			{title : 'Red text', inline : 'span', styles : {color : '#ff0000'}},
			{title : 'Red header', block : 'h1', styles : {color : '#ff0000'}},
			{title : 'Example 1', inline : 'span', classes : 'example1'},
			{title : 'Example 2', inline : 'span', classes : 'example2'},
			{title : 'Table styles'},
			{title : 'Table row 1', selector : 'tr', classes : 'tablerow1'}
		],

		// Replace values for the template plugin
		template_replace_values : {
			username : "Some User",
			staffid : "991234"
		}
	});
</script>

<script type="text/javascript">
<!--
	function check(){
		var val = document.getElementById("theme").value;
		if(val == null || val.trim() == ""){
			document.getElementById("msg").innerHTML="主题不能为空！";
			return false;
		}
		else{
			document.getElementById("msg").innerHTML="";
			return true;
		}
}
	
	String.prototype.trim = function() {
    	return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
  	}

//-->
</script>

<div id="main">

	<div class="t3">
		<table cellspacing="0" cellpadding="0" width="100%" align="center">
			<tr>
				<td style="padding-top: 12px;text-align: left;">
					<img src="<%=basePath %>images/yellow/index/home.gif" align="absbottom" />
					<b> <a
						href="<s:url action='viewCategory' namespace='/category' />?category.id=${board.category.id}">${
							board.category.name }</a> &raquo; <a
						href="<s:url action='list' namespace='/board' />?board.id=${board.id}">${
							board.name }</a>
				</td>
			</tr>
		</table>
		<br />
	</div>

	<s:form action="add" namespace="/thread" onsubmit="return check();">
		<s:hidden name="board.id" value="%{board.id}"/>
		<!-- Thread Start -->
		<div class="t" style="margin-bottom:0px; border-bottom:0">
			<table cellspacing="0" cellpadding="0" width="100%">
				<tr>
					<th class="h">
						<strong class="fl w"><b>发表帖子</b> &nbsp;
						<span style="color: red; font-weight: bold;" id="msg"></span>
						</strong>
					</th>
				</tr>
			</table>
		</div>

		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr1">
					<th style="width:20%" class="r_two" style="text-align: right">
						主题
					</th>
					<th height="100%" class="r_one" valign="top" id="td_4900235"
						style="padding:5px 15px 0 15px; border:0;width:80%; overflow:hidden">
						<s:textfield name="thread.title" cssStyle="width: 500px; " id="theme" 
						 onblur="check()"></s:textfield>
					</th>
				</tr>
				<tr class="tr1 r_one">
					<th style="width:20%" class="r_two" style="text-align: right">
						内容
					</th>
					<th style="vertical-align:bottom;padding-left:15px;border:0">
						<s:textarea name="thread.content"
							cssStyle="width: 500px; height: 200px; " ></s:textarea>
						<br />
						<br />
						<s:submit value="提交" cssClass="btn"></s:submit>
					</th>
				</tr>
			</table>
		</div>
	</s:form>

	<jsp:include flush="true" page="/forum/footer.jsp" />