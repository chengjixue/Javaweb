<%@ page contentType="text/html;charset=GB2312" %>
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/admin.css" type="text/css" rel="stylesheet">
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" background="images/header_bg.jpg" border=0>
  <TR height=56>
    <TD width=260><IMG height=56 src="images/header_left.jpg" width=260></TD>
    <TD style="FONT-WEIGHT: bold; COLOR: #fff; PADDING-TOP: 20px" align=middle>
               当前用户： &nbsp;&nbsp; ${loginName}, <% session.getAttribute("loginName"); %>
      <A style="COLOR: #fff" href="LoginServlet?op=logout" 
         target=_top  onclick="if(confirm('确定要退出吗？'))  return true; else return false;">退出系统</A> 
    </TD>
    <TD align=right width=268><IMG height=56 
      src="images/header_right.jpg" width=268></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TR bgColor=#1c5db6 height=4>
    <TD></TD></TR>
</TABLE>
</BODY>
</HTML>
    
    
