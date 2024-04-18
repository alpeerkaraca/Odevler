package UserInteractions;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckCookies extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        
        boolean cookieExists = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    cookieExists = true;
                    break;
                }
            }
        }

        response.setContentType("text/plain");
        response.getWriter().write(String.valueOf(cookieExists));
    }
}
