/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_22135;

import Dao_22135.GenericDao;
import Model_22135.Car_22135;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mirindi
 */
@WebServlet (name="DeleteCarManagement", urlPatterns = {"/deletecar"})
public class DeleteCarManagement extends HttpServlet{
       @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException{
        String delete=req.getParameter("pltno");
//        PrintWriter writer = res.getWriter();
//        writer.write(delete);
        GenericDao del=new GenericDao(Car_22135.class);
        Car_22135 delcar=new Car_22135(delete);
        del.delete(delcar);
        res.sendRedirect("/CarManagementGov/DisplayCar.jsp");
        
    }
}
