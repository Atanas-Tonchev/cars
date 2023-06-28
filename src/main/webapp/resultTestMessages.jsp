<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
      integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
      crossorigin="anonymous" referrerpolicy="no-referrer" />
<html lang="en">
<head>
    <title>Welcome to my tests</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <style>
        .button1{
            display: inline-block;
            width: 220px;
            height: 60px;
            border: 2px solid black;
            color: black;
            font-size: 20px;
            font-weight: bold;
            text-transform: uppercase;
            text-align: center;
            text-decoration: none;
            line-height: 56px;
            box-sizing: border-box;
            border-radius: 50px;
            background-color: #F257C2;
            outline: none;
            transition: all ease 0.5s;
        }
        .button{
            display: inline-block;
            width: 220px;
            height: 60px;
            border: 2px solid black;
            color: black;
            font-size: 20px;
            font-weight: bold;
            text-transform: uppercase;
            text-align: center;
            text-decoration: none;
            line-height: 56px;
            box-sizing: border-box;
            border-radius: 50px;
            background-color: #66FF99;
            outline: none;
            transition: all ease 0.5s;
        }
        .active{
            font-size: 0;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            border-left-color: transparent;
            animation: rotate 1.4s ease 0.5s infinite;
        }
        @keyframes rotate{
            0%{
                transform: rotate(360deg);
            }
        }
        .success{
            position: relative;
            background-color: #C6C6C6;
            animation: bounce .3s ease-in;
        }
        @keyframes bounce{
            0%{
                transform: scale(0.9);
            }
        }

    </style>

</head>

<body style="background-size: auto;background-color: F1E3DA; ">
<form action="CarServlet">
        <link rel="stylesheet" href="editBtn.css" />
        <input type="submit" class="btn" value="Home" >
</form>
<form action="LogOutServlet" method="post" align="right">
<link rel="stylesheet" href="editBtn.css" />
          <input type="submit" class="btn1" value="Logout" >
</form>
<div align="right">
    <button class="button1" id="btn1" onclick="ajaxCall()"><a href="processInputApiTestMessages.jsp">BACK</a></button>
</div>
    <div class="output" id="out" align="center">
        <form action="IntegrationTestMessagesServlet" method="GET">
                <c:forEach var="message" items="${list}">
                 <h2><c:out value="${message}"/></h2>
                </c:forEach>
        </form>
    </div>
<script>
function ajaxCall() {
    $(this).addClass("active");
    $(".button").addClass("success");
    $.ajax({
    			url : '#',
    			data : {
    				test : true
    			},
    			success : function(responseText) {
    				$('#message').text(responseText);
                    $(".button").removeClass("active");
                    $(".button").removeClass("success");
    			}
    		});
}
</script>
</body>
</html>