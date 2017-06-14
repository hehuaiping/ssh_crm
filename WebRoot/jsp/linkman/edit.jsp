<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加联系人</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/layer/mobile/need/layer.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layer/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/validate.js"></script>
<script type="text/javascript">
	function selectCust(){
		layer.open({
		  type: 2,
		  skin: 'layui-layer-rim', //加上边框
		  area: ['700px', '500px'], //宽高
		  content: '${pageContext.request.contextPath}/CustomerAction_getCustomerList?select=true'
		});
		
	};
	function confim(elementId,msg) {
		if($(elementId).val()=="" || $(elementId).val().trim() == "") {
			layer.tips( msg , elementId);
			return 0;
		}
	}
	function checkData() {
		if(confim('#cust_name','请选择所属客户！')==0) {
			return false;
		}
		if(confim('#lkm_name','联系人名称不能为空！')==0) {
			return false;
		}
		if(confim('#lkm_email','联系人邮箱不能为空！')==0) {
			return false;
		}
		if(confim('#lkm_position','联系人职位不能为空！')==0) {
			return false;
		}
		if(confim('#lkm_memo','联系人备注不能为空！')==0) {
			return false;
		}
		if(confim('#lkm_phone','联系人电话不能为空！')==0) {
			return false;
		}
		
		if(confim('#lkm_mobile','联系人手机号不能为空！')==0) {
			return false;
		}
	}
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		onsubmit="return checkData()"
		action="${pageContext.request.contextPath }/LinkManAction_updateLinkMan"
		method=post>
		<input type="hidden" name="lkmId" value="${linkMan.lkm_id }"/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						 height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：联系人管理 &gt; 修改联系人</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>所属客户：</td>
								<td colspan="3">
								<input type="hidden" name="customer.cust_id" style="WIDTH: 180px" id="cust_id" value="<s:property value="#linkMan.customer.cust_id" />" />
								<input type="text" readonly="readonly" placeholder="请点击右侧选择按钮并选择客户" style="WIDTH: 180px" id="cust_name" value="<s:property value="#linkMan.customer.cust_name" />"/>
									<input type="button" value="选择客户" onclick="selectCust()" />
								</td>
							</tr>
							<TR>
								<td>联系人名称：</td>
								<td>
								<INPUT class=textbox id="lkm_name"
														style="WIDTH: 180px" maxLength=50 name="lkm_name" value="${linkMan.lkm_name}" >
								</td>
								<td>联系人性别：</td>
								<td>
								<input type="radio" value="男" name="lkm_gender" <s:property value="#linkMan.lkm_gender=='男'?'checked':''" />  >男
								
								<input type="radio" value="女" name="lkm_gender" <s:property value="#linkMan.lkm_gender=='女'?'checked':''" /> >女
								</td>
							</TR>
							<TR>
								<td>联系人办公电话 ：</td>
								<td>
								<INPUT class=textbox id="lkm_phone"
														style="WIDTH: 180px" maxLength=50 name="lkm_phone" value="${linkMan.lkm_phone}">
								</td>
								<td>联系人手机 ：</td>
								<td>
								<INPUT class=textbox id="lkm_mobile"
														style="WIDTH: 180px" maxLength=50 name="lkm_mobile" value="${linkMan.lkm_mobile}">
								</td>
							</TR>
							<TR>
								<td>联系人Email：</td>
								<td>
								<INPUT class=textbox id="lkm_email"
														style="WIDTH: 180px" maxLength=50 name="lkm_email" value="${linkMan.lkm_email}">
								</td>
								<td>联系人QQ ：</td>
								<td>
								<INPUT class=textbox id="lkm_qq"
														style="WIDTH: 180px" maxLength=50 name="lkm_qq" value="${linkMan.lkm_qq}">
								</td>
							</TR>
							<TR>
								<td>联系人职位：</td>
								<td>
								<INPUT class=textbox id="lkm_position"
														style="WIDTH: 180px" maxLength=50 name="lkm_position" value="${linkMan.lkm_position}">
								</td>
								<td>联系人备注 ：</td>
								<td>
								<INPUT class=textbox id="lkm_memo"
														style="WIDTH: 180px" maxLength=50 name="lkm_memo" value="${linkMan.lkm_memo}">
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit 
														value="保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
