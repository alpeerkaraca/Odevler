<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="tr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giriş Yap</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
  
    <div class="wrapper">
      <h2>Giriş Yap</h2>
      <form action="login">
        <div class="input-box">
          <input type="text" id="user-name" name="user-name" placeholder="Kullanıcı Adı" required>
        </div>
        <div class="input-box">
          <input type="password" id="password" name="password" placeholder="Parola" required>
        </div>
        <div class="input-check-box">
          <input type="checkbox" id="remember-me" name="remember-me">
          <label for="remember-me" >Beni Hatırla</label>
        </div>
        <div class="input-box button">
          <input type="submit" value="Giriş Yap">
        </div>
        
      </form>
    </div>
    
<script>
window.onload = function() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "checkCookies", true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            if (xhr.responseText.trim() === "true") {
                window.location.href = "home.jsp";
            }
        }
    };
    xhr.send();
};
</script>
  </body>
</html>
    