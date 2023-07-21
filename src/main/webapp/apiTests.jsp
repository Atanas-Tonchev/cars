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
        .button1 {
            display: inline-block;
            width: 220px;
            height: 60px;
            border: 2px solid black;
            color: black;
            font-size: auto;
            font-weight: bold;
            text-transform: uppercase;
            text-align: center;
            text-decoration: none;
            line-height: 56px;
            box-sizing: border-box;
            border-radius: 50px;
            background-color: #57F2D5;
            outline: none;
            transition: all ease 0.5s;
        }
        .button2 {
            display: inline-block;
            width: 220px;
            height: 60px;
            border: 2px solid black;
            color: black;
            font-size: auto;
            font-weight: bold;
            text-transform: uppercase;
            text-align: center;
            text-decoration: none;
            line-height: 56px;
            box-sizing: border-box;
            border-radius: 50px;
            background-color: #57F2D5;
            outline: none;
            transition: all ease 0.5s;
        }
        .button3 {
            display: inline-block;
            width: 220px;
            height: 60px;
            border: 2px solid black;
            color: black;
            font-size: auto;
            font-weight: bold;
            text-transform: uppercase;
            text-align: center;
            text-decoration: none;
            line-height: 56px;
            box-sizing: border-box;
            border-radius: 50px;
            background-color: #57F2D5;
            outline: none;
            transition: all ease 0.5s;
        }
        .active {
            font-size: 0;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            border-left-color: transparent;
            animation: rotate 1.4s ease 0.5s infinite;
        }
        @keyframes rotate {
            0%{
                transform: rotate(360deg);
            }
        }
        .success {
            position: relative;
            background-color: #C6C6C6;
            animation: bounce .3s ease-in;
        }
        @keyframes bounce{
            0%{
                transform: scale(0.9);
            }
        }
        .loader {
            position: fixed;
            top: 10%;
            left: 50%;
            width: 100vw;
            height: 100vh;
            display: flex;
            background: #65606000;
            transition: opacity 1.75s, visibility 1s;

        }
        .loader--hidden {
            opacity: 0;
            visibility: hidden;
        }

        .loader::after {
            content: "";
            width: 25px;
            height: 25px;
            border: 5px solid #dddddd;
            border-top-color: #009578;
            border-radius: 50%;
            animation: loading 0.75s ease infinite;
        }
        @keyframes loading {
            from { transform: rotate(0turn)}
            to {transform: rotate(1turn)}
        }
        .input {
            border-collapse: collapse;
            border-radius: 10px;
            box-shadow: -5px -5px 15px rgba(255,255,255,0.1),
            5px 5px 15px rgba(0,0,0,0.35),
            inset -5px -5px 15px rgba(255,255,255,0.1),
            inset 5px 5px 15px rgba(0,0,0,0.35);
            color: #fff;
            letter-spacing: 0.1em;
            font-size: 3em;
            background: #00dfc4;
            color: #223243;
            padding: 10px 0;
            font-weight:300;
            cursor: pointer;
            box-shadow: -5px -5px 15px rgba(255,255,255,0.1),
            5px 5px 15px rgba(0,0,0,0.35),
            inset -5px -5px 15px rgba(255,255,255,0.1),
            inset 5px 5px 15px rgba(0,0,0,0.35);
        }

        .enter {
            border-collapse:separate;
            border-spacing:0 90px;
        }
        .auth {
            text-align: center;
            font-size: 17px;
            color: black;
        }
    </style>

</head>
<div class="txt" >
   <center style="color: black;">
      <h1>Please select your test choice</h1>
   </center>
</div>
<form action="CarServlet">
        <link rel="stylesheet" href="editBtn.css" />
        <input type="submit" class="btn" value="Home" >
</form>
<form action="LogOutServlet" method="post" align="right">
<link rel="stylesheet" href="editBtn.css" />
          <input type="submit" class="btn1" value="Logout" >
</form>

<body style="background-size: auto;background-color: #CC9999; ">
<form action="IntegrationTestMessagesServlet" method="post">
    <table class="input" align="center">
        <tr>
            <td>
                <i class="fa-regular fa-user"></i>
                <span>username</span>
                <td>
                    <input type="text" name="Username" ></input>
                </td>
            </td>
        </tr>
        <tr>
            <td>
                <i class="fa-solid fa-lock"></i>
                <span>password</span>
                <td>
                    <input type="password" name="Password" ></input>
                </td>          
            </td>
        </tr>
        <tr>
            <td>
                <i class="fa-regular fa-envelope"></i>
                <span>e-mail</span>
                <td>
                    <input type="text" name="Email" ></input>
                </td> 
            </td>
        </tr>
        <tr>
            <td>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.18/css/bootstrap-select.min.css" />
                <i class="fa-brands fa-critical-role"></i>
                <label for="auth">role/roles</label>  
                <td>
                    <div class="auth">
                        <select class="roles" multiple name="userTypes">
                            <option value="1">admin</option>
                            <option value="2">user</option>
                            <option value="3">mod</option>
                        </select>
                    </div> 
                </td>              
            </td>
        </tr>
    </table>
    <table class="enter" align="center" >
                <tr align="center">
                    <td align="center">
                        <div align="center">
                           <button type="submit" class="button2" id="btn" onclick="ajaxCall2()">Integration Test</button>
                        </div>
                    </td>
                </tr>
    </table>
</form>      
<table>
    <td>
        <form action="UnitTestConnectionServlet" method="get">
            <button class="button1" onclick="ajaxCall()">Unit Test Connection</button>
        </form>
    </td>
    <td>
        <form action="JarExecutorServletTestApi" method="GET">
            <div>
                <button class="button3" onclick="reload()">run jar executor</button>   
            </div>     
        </form>
    </td> 
    <td>
        <form action="LoggerFileJarServlet" method="GET">
            <div class="loader">
                <button hidden id="autoClickBtn" onclick="refresh()"></button>
            </div> 
        </form>
    </td>
       
</table>
<div>
    <form action="IntegrationTestMessagesServlet" method="GET">      
        <c:forEach var="list" items="${list}">
            <h3><c:out value="${list}"/></h3>
        </c:forEach>
    </form> 
</div>
<div>
    <form action="JarExecutorServletTestApi" method="GET">      
        <c:forEach var="messages" items="${jar}">
            <h3><c:out value="${messages}"/></h3>
        </c:forEach>
    </form> 
</div>
<div>
    <form action="UnitTestConnectionServlet" method="post">
        <c:forEach var="loggApi" items="${loggApi}">
           <h3><c:out value="${loggApi}"/></h3>
        </c:forEach>
    </form>
</div>
<div>
    <form action="LoggerFileJarServlet" method="GET">
        <c:forEach var="logg" items="${logg}">
            <h3><c:out value="${logg}"/></h3>
        </c:forEach>
    </form> 
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.18/js/bootstrap-select.min.js"></script>
<script>
    $(document).ready(function(){
        $('.roles').selectpicker();
    });
</script>
<script>
function ajaxCall() {
    $(this).addClass("active");
    $(".button1").addClass("success");
    }
function ajaxCall2() {
    $(this).addClass("active");
    $(".button2").addClass("success");
    }
function refresh() {
    $(this).addClass("active");
    $(".loader").addClass("success");
    $.ajax({
    	url : 'LoggerFileJarServlet',
    	data : {
    		logg : true
    	},
    	success : function(responseText) {
    		$('#logg').text(responseText);
            $(".loader").removeClass("active");
            $(".loader").removeClass("success");

    	}
    	});
    }
    function reload() {
        $(this).addClass("active");
        $(".button3").addClass("success");
        refresh().block;
        $.ajax({
    			url : 'JarExecutorServletTestApi',
    			data : {
    				jar : true
    			},
    			success : function(responseText) {
    				$('#jar').text(responseText);
                    $(".button3").removeClass("active");
                    $(".button3").removeClass("success");

    			}
    		});
    }

setInterval(function(){
    window.onload = document.getElementById('autoClickBtn').click();
}, 20000);

window.addEventListener("load", () => {
    document.querySelector(".loader").classList.add("loader--hidden");
    document.querySelector(".loader").addEventListener("transitionend",() => {
        document.body.removeChild(document.querySelector(".loader"));
    });
});

</script>
<script>

</script>
</body>
</html>