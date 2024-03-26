<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="tr">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kayıt Ol</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <div class="wrapper">
      <h2>Kayıt Ol</h2>
      <form action="register">
        <div class="input-box">
          <input type="text" id="name" name="name" placeholder="Ad" required>
        </div>
        <div class="input-box">
          <input type="text" id="surname" name="surname" placeholder="Soyad" required>
        </div>
        <div class="input-box">
          <input type="email" id="email" name="email" placeholder="E-Posta" required>
        </div>
        <div class="input-box">
          <input type="password" id="password" name="password" placeholder="Parola" required>
        </div>
        <div class="input-box button">
          <input type="submit" value="Kayıt Ol">
        </div>
      </form>
    </div>
  </body>
</html>
    