<%@page import="java.util.List"%>
<%@page import="com.cb.tracker.models.Orders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
      
<!DOCTYPE html>
<html>
<body>
....
    <p>Name: ${message} </p>
<table>
    <%
    	List<Orders> orders =(List<Orders>)request.getAttribute("OrderList");
    	for(Orders s:orders ){
	
//     	out.print(s.getAnalyst_id());
//     	out.print(s.getAsset_symbol());
    	
    %>
<tr>
<td> <%=s.getAnalyst_id()%></td>
<td><%=s.getAsset_symbol()%> </td>

<%} %>>
</tr>
</table>
</body>
</html>