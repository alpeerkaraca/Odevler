package UserRegister;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

//import org.mindrot.jbcrypt.BCrypt;



public class RegisterForm extends HttpServlet {
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        // Parolayı bcrypt ile şifrele
       //String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        
        PrintWriter out = res.getWriter();
        out.println("Ad");
        
    }
    }
