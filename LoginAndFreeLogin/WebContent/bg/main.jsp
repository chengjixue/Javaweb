<%@ page contentType="text/html;charset=GB2312" %>
<HTML><HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
</HEAD>
<BODY>
<%@ include file="checkLogin.jsp"%>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TR height=28>
    <TD background=images/title_bg1.jpg>��ǰλ��: </TD></TR>
  <TR>
    <TD bgColor=#b1ceef height=1></TD></TR>
  <TR height=20>
    <TD background=images/shadow_bg.jpg></TD></TR></TABLE>

<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
  <TR height=22>
    <TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff" 
    align=middle background=images/title_bg2.jpg>���������Ϣ</TD></TR>
  <TR bgColor=#ecf4fc height=12>
    <TD></TD></TR>
  <TR height=20>
    <TD></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0>
  <TR>
    <TD align=right width=100>��½�ʺţ�</TD>
    <TD style="COLOR: #880000">${loginName}</TD></TR>
  <TR>
    <TD align=right>��ʵ������</TD>
    <TD style="COLOR: #880000">������</TD></TR>
  <TR>
    <TD align=right>��½������</TD>
    <TD style="COLOR: #880000">58</TD></TR>
  <TR>
    <TD align=right>�����ɫ��</TD>
    <TD style="COLOR: #880000">ϵͳ����Ա</TD></TR>
  <TR>
</TR></TABLE></BODY></HTML>