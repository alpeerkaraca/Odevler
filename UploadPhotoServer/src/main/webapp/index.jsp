<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="tr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fotoğraf Yükleme Arayüzü</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


</head>
<body>
    
    <div class="wrapper">
        <h2>Fotoğraf Yükleme Uygulaması</h2>
        <form method="post" action="UploadPhoto" enctype="multipart/form-data">
          <div class="input-box upload-file">
            <input type="file" name="file" id="file" multiple >
          </div>
          <div class="input-box">
          <div class="input-box button">
            <input type="submit" value="Fotoğrafları Yükle">
          </div>
        </form>
      </div>
</body>
<style>
body {
  background: #4070f4;}
</style>

</html>
