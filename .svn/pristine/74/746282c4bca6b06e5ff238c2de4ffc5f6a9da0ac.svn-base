<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<jsp:include flush="true" page="/forum/header.jsp"></jsp:include>
<script type="text/javascript">
<!--
	function check_password(){
		var pwd = document.getElementById("password1").value;
		var val = document.getElementById("password2").value;
		if(val != pwd){
			document.getElementById("msg").innerHTML="两次密码输入不一致，请重新输入！";
			return false;
		}
		else{
			document.getElementById("msg").innerHTML="";
			return true;
		}
}

	function check_email(){
		var filter = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
		var val = document.getElementById("email").value;
		if(val == "") {
			document.getElementById("msg2").innerHTML="";
			return true;
		}
		else if(!filter.test(val)){
			document.getElementById("msg2").innerHTML="电子邮件格式不正确，请重新输入";
			return false;
		}
		else {
			document.getElementById("msg2").innerHTML="";
			return true;
		}
	}
	
	function check_all(){
		if (!check_password()) return false;
		if (!check_email()) return false;
		else return true;
		
	}
	
//-->
</script>

<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w">注册用户</strong> &nbsp;
					<span style="color: red; font-weight: bold; ">${ message }</span>
				</th>
			</tr>
		</table>
	</div>

	<s:form action="add" namespace="/person" onsubmit="return check_all();">
		<s:actionerror cssStyle="color:red"/>
		<s:fielderror cssStyle="color:red"></s:fielderror>
		<div class="t t2">
		<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
		<tr class="tr3">
					<td style="width: 120px; ">
						帐号:
					</td>
					<td>
						<s:textfield name="person.account"></s:textfield>
					</td>
				</tr>
		<tr class="tr3">
					<td>
						密码:
					</td>
					<td>
						<s:password name="person.password" id="password1"></s:password>
					</td>
				</tr>
		<tr class="tr3">
					<td>
						确认密码:
					</td>
					<td>
						<input type="password" id="password2" onblur="check_password()">
						<span id="msg" style="color:red"></span>
					</td>
					
				</tr>
		<tr class="tr3">
					<td>
						姓名:
					</td>
					<td>
						<s:textfield name="person.name"></s:textfield>
					</td>
				</tr>
		<tr class="tr3">
					<td>
						性别:
					</td>
					<td>
						<s:select list="#{'男':'男','女':'女'}" 
						name="person.sex"></s:select>
					</td>
				</tr>
		<tr class="tr3">
					<td>
						电子邮件:
					</td>
					<td>
						<s:textfield name="person.email" id="email" onblur="check_email()"></s:textfield>
						<span id="msg2" style="color:red"></span>
					</td>
				</tr>
		<tr class="tr3">
					<td>
						生日:
					</td>
					<td>
						<s:textfield name="person.birthday"></s:textfield>
					</td>
				</tr>
		<tr class="tr3">
					<td colspan="2">
						<s:submit cssClass="btn" value="注册" />
					</td>
				</tr>
			</table>
		</div>
	</s:form>

	<jsp:include flush="true" page="/forum/footer.jsp" />