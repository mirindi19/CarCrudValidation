package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Model_22135.Car_22135;
import Dao_22135.GenericDao;
import java.util.Map;

public final class DisplayCar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html\n");
      out.write("    ");

Map<String , String> ErrorMessage = (Map) session.getAttribute("message");
pageContext.setAttribute("errors", ErrorMessage);
session.removeAttribute("message");

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("        <title>Display Form</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"all\">\n");
      out.write("        <form action=\"SaveCar\"> \n");
      out.write("            <h1>Car Registration</h1>\n");
      out.write("            \n");
      out.write("                <label style=\"font-size: 20px\">PlatNumber:</label><br/>\n");
      out.write("                <input type=\"text\" name=\"pltno\" class=\"txt\" required> <br/>\n");
      out.write("             <span style=\"color:red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errors[\"PlatNumberMessage\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("           <br/>\n");
      out.write("           \n");
      out.write("            \n");
      out.write("            <label style=\"font-size: 20px\">Manufactary Date:</label><br/>\n");
      out.write("            <input type=\"date\" name=\"mfd\" class=\"txt\" required><br/>\n");
      out.write("             <span style=\"color:red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errors[\"date_error\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("            <br/>\n");
      out.write("            \n");
      out.write("            <label style=\"font-size: 20px\">Cost:</label><br/>\n");
      out.write("            <input type=\"text\" name=\"cost\" class=\"txt\" required><br/>\n");
      out.write("             <span style=\"color:red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errors[\"cost_error\"]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("            <br/>\n");
      out.write("            \n");
      out.write("            <label style=\"font-size: 20px\">Institution:</label><br>\n");
      out.write("             <select name=\"institution\" class=\"txt\">\n");
      out.write("                   <option>BENZ</option>\n");
      out.write("                   <option>TOYOTA</option>\n");
      out.write("                   <option>MINIVAN</option>\n");
      out.write("                   <option>SEDAN</option>\n");
      out.write("             </select><br/><br/>\n");
      out.write("            \n");
      out.write("             <button class=\"savebtn\">Save</button>\n");
      out.write("             \n");
      out.write("        </form>\n");
      out.write("            \n");
      out.write("             <br/><br/><br/>\n");
      out.write("        \n");
      out.write("        <table border=\"2\" cellpadding=\"10\" cellspacing=\"0\">\n");
      out.write("            <caption style=\"font-size: 25px;\">Car that are save</caption>\n");
      out.write("            <tr>\n");
      out.write("            <th>Plant Number</th>\n");
      out.write("            <th>manafacturing Date</th>\n");
      out.write("            <th>Cost</th>\n");
      out.write("            <th>Institution</th>\n");
      out.write("            <th colspan=\"2\">Operation</th>\n");
      out.write("            </tr>\n");
      out.write("          \n");
      out.write("            ");

                GenericDao dao= new GenericDao(Car_22135.class);
                List<Car_22135> car = dao.findAll();
                for(Car_22135 car_22135 : car){
                
                
      out.write("\n");
      out.write("             <tr>\n");
      out.write("                <td>");
      out.print( car_22135.getPlate_Number());
      out.write("</td>\n");
      out.write("                 <td>");
      out.print( car_22135.getManafacturing_date());
      out.write("</td>\n");
      out.write("                  <td>");
      out.print( car_22135.getCost());
      out.write("</td>\n");
      out.write("                   <td>");
      out.print( car_22135.getInstitution());
      out.write("</td>\n");
      out.write("                <td><a href=\"deletecar?pltno=");
      out.print( car_22135.getPlate_Number());
      out.write("\">Delete</a></td>\n");
      out.write("                <td><a href=\"UpdateCarForm.jsp?pltno=");
      out.print( car_22135.getPlate_Number());
      out.write("\">Update</a></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }

      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
