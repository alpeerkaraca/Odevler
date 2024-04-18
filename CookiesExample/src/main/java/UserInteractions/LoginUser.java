package UserInteractions;
import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginUser extends HttpServlet{
    private static final long serialVersionUID = 1L;
    

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user-name");
        String password = request.getParameter("password");
        boolean rememberMe = request.getParameter("remember-me") != null;
        
        if (rememberMe) {
            Cookie usernameCookie = new Cookie("username", username);
            Cookie pwCookie = new Cookie ("password", password);
            
            
            usernameCookie.setMaxAge(60 * 60);
            pwCookie.setMaxAge(60 * 60);
            
            response.addCookie(usernameCookie);
            response.addCookie(pwCookie);

            
            response.sendRedirect("home.jsp");
        }
        
        else {
        	response.sendRedirect("home.jsp");
        }
        
        

    }

}
