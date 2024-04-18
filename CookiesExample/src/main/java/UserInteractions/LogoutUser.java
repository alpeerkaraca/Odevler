package UserInteractions;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
                if (cookie.getName().equals("password")) {
                	cookie.setMaxAge(0);
                	response.addCookie(cookie);
                }
            }
        }
        // Redirect back to login page
        response.sendRedirect("login.jsp");
    }
}
