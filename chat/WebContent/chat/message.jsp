<%@ page language="java" import="java.util.*" contentType="text/html; charset=GB2312" %>
<html>
  <head>
  </head>
  <body>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TR height=28>
    <TD>адлЛйр╢╟©з: </TD>
  </TR>
  <TR>
    <TD bgColor=#b1ceef height=1></TD>
  </TR>
  <TR height=500 valign="top">
    <TD>
<%
response.setHeader("refresh", "2");
String chatwords=(String)application.getAttribute("chatwords");
    if(chatwords!=null){
    	out.print(chatwords);
    }
%>    
     
    </TD></TR></TABLE>
  </body>
</html>
