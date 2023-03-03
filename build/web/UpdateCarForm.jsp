<%-- 
    Document   : UpdateCarForm
    Created on : Jul 16, 2021, 6:38:05 AM
    Author     : Mirindi
--%>

<%@page import="java.util.List"%>
<%@page import="Model_22135.Car_22135"%>
<%@page import="Dao_22135.GenericDao"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%
Map<String , String> ErrorMessage = (Map) session.getAttribute("message");
pageContext.setAttribute("errors", ErrorMessage);
session.removeAttribute("message");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" type="text/css" href="style.css">
        <title>UpdateForm</title>
    </head>
    <body>
        <%
            String plat_n= request.getParameter("pltno");
            GenericDao dao = new GenericDao(Car_22135.class);
            Car_22135 cr =(Car_22135) dao.findById(plat_n);
         
            %>
        
         <div class="all">
        <form action="UpdateCar"> 
            <h1>Update car</h1>
            
                <label style="font-size: 20px">PlatNumber:</label><br/>
                <input type="text" name="pltno" class="txt" value="<%= cr.getPlate_Number() %>" required> <br/>
             <span style="color:red;">${errors["PlatNumberMessage"]}</span>
           <br/>
           
            
            <label style="font-size: 20px">Manufactary Date:</label><br/>
            <input type="date" name="mfd" class="txt" value="<%= cr.getManafacturing_date() %>" required><br/>
             <span style="color:red;">${errors["date_error"]}</span>
            <br/>
            
            <label style="font-size: 20px">Cost:</label><br/>
            <input type="text" name="cost" class="txt" value="<%= cr.getCost() %>" required><br/>
             <span style="color:red;">${errors["cost_error"]}</span>
            <br/>
            
            <label style="font-size: 20px">Institution:</label><br>
             <select name="institution" class="txt">
                   <option>BENZ</option>
                    <option>TOYOTA</option>
                   <option>MINIVAN</option>
                   <option>SEDAN</option>                 
             </select><br/><br/>
            
             <button class="savebtn">Update</button>
             
        </form>
 
        </table>
        </div>
        
        
        
        
    </body>
</html>
