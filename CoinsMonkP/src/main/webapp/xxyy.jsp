<%@page import="java.util.List"%>
<%@page import="com.cb.tracker.models.Orders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Responsive Table + Detail View</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="./reportstyle.css">

</head>
<body>

<!-- partial:index.partial.html -->
<h1>
  Providers
</h1>
<p>
  (An example table + detail view scenario)
</p>
<main>
<div class='detail'>
  <table>
    <thead>
      <tr>
        <th>
          Provider Name
        </th>
        <th>
          E-mail
        </th>
        <th></th>
      </tr>
    </thead>
    <tfoot>
      <tr>
        <th colspan='3'>
          Year: 2014
        </th>
      </tr>
    </tfoot>
    <tbody>
    <%List<Orders> orders =(List<Orders>)request.getAttribute("OrderList");
	for(Orders s:orders ){ %>
      <tr>
        <td data-title='Provider Name'>
          <%=s.getOrder_id() %>
        </td>
        <td data-title='E-mail'>
          <%=s.getAsset_symbol() %>
        </td>
        <td class='select'>
          <a class='button' href='#'>
            Select
          </a>
        </td>
      </tr>
     <%} %> 
    </tbody>
  </table>
  </div>
  <div class='detail'>
    <div class='detail-container'>
      <dl>
        <dt>
          Provider Name
        </dt>
        <dd>
          John Doe
        </dd>
        <dt>
          E-mail
        </dt>
        <dd>
          email@example.com
        </dd>
        <dt>
          City
        </dt>
        <dd>
          Detroit
        </dd>
        <dt>
          Phone-Number
        </dt>
        <dd>
          555-555-5555
        </dd>
        <dt>
          Last Update
        </dt>
        <dd>
          Jun 20 2014
        </dd>
        <dt>
          Notes
        </dt>
        <dd>
          Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.
        </dd>
      </dl>
    </div>
    <div class='detail-nav'>
      <button class='close'>
        Close
      </button>
    </div>
  </div>
</main>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script  src="./reportscript.js"></script>
</form>
</body>
</html>
