<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.cb.tracker.models.Orders"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login JSP sample</title>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
<!-- <link href="/css/style.css" type="text/css" rel="stylesheet"/> -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/reportstyle.css" />
</head>

<body>
	<!-- partial:index.partial.html -->
Welcome <%=session.getAttribute("userid") %>
	<h1>ORDER HISTORY</h1>
	<div class="tbl-header">
	<table>
	
		<thead>
			<tr>
				<th>OrderId
				<th>Buy/Sell
				<th>Stock
				<th>Market
				<th>Price
				<th>Volume
				<th>Status
				<th>TimeOfOrder
				
		</thead>
		</table>
		</div>
		<div class="tbl-content">
		<table>
		<tbody>
		<%
List<Orders> orders = (List<Orders>) request.getAttribute("OrderList");
if(orders.size()>=1){
for (Orders s : orders) {
%>
			<tr>
				<td><%=s.getOrder_id() %>
				<td><%=s.getOrder_type() %>
				<td><%=s.getAsset_symbol()%>
					
				<td><%=s.getMarket_symbol() %>
				<td><%=s.getPrice() %>
				<td><%=s.getQuantity() %>
				<td><%=s.getOrder_status() %>
				<td><%=s.getOrder_time() %>
				
			<%} }else{%>
			<tr class="disabled">
				<td>NO Record found
			<%} %>
		</tbody>
	</table>
	</div>
</body>
</html>
