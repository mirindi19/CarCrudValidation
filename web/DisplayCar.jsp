<%-- 
    Document   : DisplayCar
    Created on : Jul 16, 2021, 2:22:06 AM
    Author     : Mirindi
--%>

<%@page import="java.util.List"%>
<%@page import="Model_22135.Car_22135"%>
<%@page import="Dao_22135.GenericDao"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html
    <%
Map<String , String> ErrorMessage = (Map) session.getAttribute("message");
pageContext.setAttribute("errors", ErrorMessage);
session.removeAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Display Form</title>
    </head>
    <body>
        <div class="all">
        <form action="SaveCar"> 
            <h1>Car Registration</h1>
            
                <label style="font-size: 20px">PlatNumber:</label><br/>
                <input type="text" name="pltno" class="txt" required> <br/>
             <span style="color:red;">${errors["PlatNumberMessage"]}</span>
           <br/>
           
            
            <label style="font-size: 20px">Manufactary Date:</label><br/>
            <input type="date" name="mfd" class="txt" required><br/>
             <span style="color:red;">${errors["date_error"]}</span>
            <br/>
            
            <label style="font-size: 20px">Cost:</label><br/>
            <input type="text" name="cost" class="txt" required><br/>
             <span style="color:red;">${errors["cost_error"]}</span>
            <br/>
            
            <label style="font-size: 20px">Institution:</label><br>
             <select name="institution" class="txt">
                   <option>BENZ</option>
                   <option>TOYOTA</option>
                   <option>MINIVAN</option>
                   <option>SEDAN</option>
             </select><br/><br/>
            
             <button class="savebtn">Save</button>
             
        </form>
            
             <br/><br/><br/>
        
        <table border="2" cellpadding="10" cellspacing="0">
            <caption style="font-size: 25px;">Car that are save</caption>
            <tr>
            <th>Plant Number</th>
            <th>manafacturing Date</th>
            <th>Cost</th>
            <th>Institution</th>
            <th colspan="2">Operation</th>
            </tr>
          
            <%
                GenericDao dao= new GenericDao(Car_22135.class);
                List<Car_22135> car = dao.findAll();
                for(Car_22135 car_22135 : car){
                
                %>
             <tr>
                <td><%= car_22135.getPlate_Number()%></td>
                 <td><%= car_22135.getManafacturing_date()%></td>
                  <td><%= car_22135.getCost()%></td>
                   <td><%= car_22135.getInstitution()%></td>
                <td><a href="deletecar?pltno=<%= car_22135.getPlate_Number()%>">Delete</a></td>
                <td><a href="UpdateCarForm.jsp?pltno=<%= car_22135.getPlate_Number()%>">Update</a></td>
            </tr>
            <%
                }
%>
            </tbody>
        </table>
        </div>
    </body>
</html>
