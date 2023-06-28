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

<table>
    <td>
        <form action="UnitTestConnectionServlet" method="post">
            <button class="button" id="btn" onclick="ajaxCall()">Test Connection</button>
        </form>
    </td>
    <td>
        <form action="IntegrationTestMessagesServlet" method="post">
            <a href="processInputApiTestMessages.jsp" class="button1" onclick="ajaxCall1()">Test Messages</a>
        </form>
    </td>
</table>
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