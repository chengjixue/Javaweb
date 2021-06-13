<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<body>
<%! long menFree=Runtime.getRuntime().freeMemory(); %>
<%! long menTotal=Runtime.getRuntime().totalMemory(); %>
<%! double percent =((double)menFree)/menTotal; %>
<%
System.out.println(menFree);
if(percent<0.5){
%>
<jsp:forward page="forward.jsp"/>
<%
   }else{
%>
<jsp:forward page="forward.html"/>
<%
   }
%>


</body>
</html>