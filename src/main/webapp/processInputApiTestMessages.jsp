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
            background-color: #57F2D5;
            outline: none;
            transition: all ease 0.5s;
        }
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
            background-color: #57F2D5;
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

<form action="CarServlet">
<link rel="stylesheet" href="editBtn.css" />
    <input type="submit" class="btn" value="Home" >
</form>
<form action="LogOutServlet" method="post" align="right">
<link rel="stylesheet" href="editBtn.css" />
    <input type="submit" class="btn1" value="Logout" >
</form>
</head>
    <body style="background-size: auto;background-color: #CC9999; ">
        <form action="IntegrationTestMessagesServlet" method="post">
            <table class="input" align="center">
                <div align="center">
                    <h1>Integration test</h1>
                </div>
            <tr>
                <td>
                    <i class="fa-regular fa-user"></i>
                    <span>username</span>
                    <td>
                        <input type="text" name="name" ></input>
                    </td>
                </td>
            </tr>
            <tr>
                <td>
                    <i class="fa-solid fa-lock"></i>
                    <span>password</span>
                    <td>
                        <input type="password" name="password" ></input>
                    </td>          
                </td>
            </tr>
            <tr>
                <td>
                    <i class="fa-regular fa-envelope"></i>
                    <span>e-mail</span>
                    <td>
                        <input type="text" name="email" ></input>
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
                            <select class="roles" multiple name="userType">
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
                       <button type="submit" class="button" id="btn" onclick="ajaxCall()">Test Messages</button>
                    </div>
                </td>
            </tr>
        </table>
    </form>
    <div align="right">
        <button class="button1" id="btn1" onclick="ajaxCall1()"><a href="apiTests.jsp">BACK</a></button>
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
            $(".button").addClass("success");
        }
        function ajaxCall1() {
            $(this).addClass("active");
            $(".button1").addClass("success");
        }    
    </script>
    
    </body>
</html>