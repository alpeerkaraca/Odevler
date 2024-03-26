package UserRegister;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import at.favre.lib.crypto.bcrypt.BCrypt.Hasher;


public class RegisterForm extends HttpServlet {
    
    public void doGet( HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");     
        String hashedPW = null;
        try {
			 hashedPW = HashPW(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("<html><body>");
        


        
        out.println("<p>Ad:" + name + "</p>");
        out.println("<p>Soyad:" + surname + "</p>");
        out.println("<p>E-posta:" + email + "</p>");
        out.println("<p>Parola (Sifreli): " + hashedPW + "</p>");
        out.println("<script>var userAgentString = navigator.userAgent; var browserName;\r\n"
        		+ "if (userAgentString.indexOf(\"Chrome\") != -1) {\r\n"
        		+ "    browserName = \"Google Chrome\";\r\n"
        		+ "} else if (userAgentString.indexOf(\"Firefox\") != -1) {\r\n"
        		+ "    browserName = \"Mozilla Firefox\";\r\n"
        		+ "} else if (userAgentString.indexOf(\"Safari\") != -1 && userAgentString.indexOf(\"Chrome\") == -1) {\r\n"
        		+ "    browserName = \"Safari\";\r\n"
        		+ "} else if (userAgentString.indexOf(\"Opera\") != -1 || userAgentString.indexOf(\"OPR\") != -1) {\r\n"
        		+ "    browserName = \"Opera\";\r\n"
        		+ "} else if (userAgentString.indexOf(\"Edge\") != -1) {\r\n"
        		+ "    browserName = \"Microsoft Edge\";\r\n"
        		+ "} else if (userAgentString.indexOf(\"MSIE\") != -1 || userAgentString.indexOf(\"Trident\") != -1) {\r\n"
        		+ "    browserName = \"Internet Explorer\";\r\n"
        		+ "} else {\r\n"
        		+ "    browserName = \"Bilinmiyor\";\r\n"
        		+ "}alert(browserName);</script>");
        out.println("</body></html>");

        
        
    }
    
    public static String HashPW(String password) throws NoSuchAlgorithmException {

        
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());

        
        String encodedHashedPassword = Base64.getEncoder().encodeToString(hashedPassword);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);

        return encodedHashedPassword;
    }
    }
