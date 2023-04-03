<link rel="stylesheet" href="editBtn.css" />
<html>
<head>
<h1>Successful deleted!</h1>
<script type = "text/javascript">
    function sample() {
    location = "CarServlet";
    }
    document.write("<h1>The page is  redirected in 5 seconds.</h1>");
    setTimeout('sample()', 5000);
</script>
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
<h1>Click the button, is automatically redirected to home page.</h1>
<form>
<input type = "button" class="btn" value = "click" onclick = "sample();" />
</form>
</body>
</html>