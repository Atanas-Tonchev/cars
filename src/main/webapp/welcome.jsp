
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.haemimont.cars.utils.EncryptionPass" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="editBtn.css" />
<link rel="stylesheet" href="wallpaperflare.com_wallpaper.jpg">

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Welcome</title>
    </head>
    <body background="wallpaperflare.com_wallpaper.jpg" style="background-size: auto;">
    <%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
    for(Cookie cookie : cookies){
    	if(cookie.getName().equals("Username")) userName = cookie.getValue();
    }
    }
    if(userName == null) response.sendRedirect("login.html");
    %>
    <h2>Hi <%=userName %>, Login successful.</h2>
       <form action="LogOutServlet" method="post" align="right">
          <input type="submit" class="btn1" value="Logout" >
       </form>
    <br>
        <center>
           <h1>WELCOME TO MY SERVER</h1>
        </center>
        <form action="CarServlet" align="center">
           <input type="submit" class="btn" value="Home"  >
        </form>
    </br>
    </body>
