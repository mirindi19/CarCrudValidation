/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service_22135;

import Dao_22135.GenericDao;
import Model_22135.Car_22135;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mirindi
 */
@WebServlet (name="SaveCarManagement", urlPatterns = {"/SaveCar"})
public class SaveCarManagement extends HttpServlet{
        Map<String, String> CarError;
      @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException{
        String platNo=req.getParameter("pltno");
        
       String dt=req.getParameter("mfd");
       LocalDate manudate=LocalDate.parse(dt);
       
       String cst=req.getParameter("cost");
       Long cost=Long.parseLong(cst);
       
       String institution=req.getParameter("institution");
       
       Car_22135 car=new Car_22135(platNo, manudate, cost, institution);
       if(validation(car)){
         GenericDao sv= new GenericDao(Car_22135.class);
            sv.create(car);
            res.sendRedirect("/CarManagementGov/DisplayCar.jsp");
       }else{
           req.getSession().setAttribute("message", CarError);
           res.sendRedirect("/CarManagementGov/DisplayCar.jsp");
       }
       
        

    }
    
    public boolean  validation(Car_22135 car_22135){
        CarError = new HashMap<>();
        if(car_22135.getPlate_Number().isEmpty()){
            CarError.put("PlatNumberMessage", "Pleace insert platnumber");
        } 
        if(!car_22135.getPlate_Number().matches("GR[0-9]{3}[A-Z]{1}") && !car_22135.getPlate_Number().matches("GP[0-9]{3}[A-Z]")){
            CarError.put("PlatNumberMessage", "plat doesn't follow the rule");
        }
        if(car_22135.getCost() < 15000000){
            CarError.put("cost_error", "cost of car must be greater than 15000000");
        }
        if(car_22135.getCost() > 60000000){
            CarError.put("cost_error", "cost of car must be less than 60000000");
        }
        if(car_22135.getManafacturing_date().isEqual(LocalDate.now()) || car_22135.getManafacturing_date().isAfter(LocalDate.now())){
            CarError.put("date_error", "date must be in past ");
        }else if(Period.between(car_22135.getManafacturing_date(), LocalDate.now()).getYears()>5){
            CarError.put("date_error", "date must be older than 5 year");
        }
        if(CarError.isEmpty()){
            return true;
        }
        
        return false;
        
    }
}
