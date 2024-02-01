<%
String message = (String)session.getAttribute("msg");
if(message != null)
{
%>
<h4 style="text-align: center; color: red;"><%=message%></h4>
<% 
}
session.removeAttribute("msg");
%>