<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
      integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
      crossorigin="anonymous" referrerpolicy="no-referrer" />
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="styleJokes.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <style>
        .button{
            display: inline-block;
            width: 220px;
            height: 60px;
            border: 2px solid #fff;
            color: #fff;
            font-size: 20px;
            font-weight: bold;
            text-transform: uppercase;
            text-align: center;
            text-decoration: none;
            line-height: 56px;
            box-sizing: border-box;
            border-radius: 50px;
            background-color: transparent;
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
            background-color: #fff;
            animation: bounce .3s ease-in;
        }
        @keyframes bounce{
            0%{
                transform: scale(0.9);
            }
        }
    
    </style>
</head>
<body>
<div id="container" style="background-position: center;background-size:cover;">
    <form action="CarServlet">
        <link rel="stylesheet" href="editBtn.css" />
        <input type="submit" class="btn" value="Home" >
    </form>
    <div class="box">
        <div class="inner">
            <span>Jokes</span>
        </div>
        <div class="inner">
            <span>Jokes</span>
        </div>
    </div>
    <div class="output" id="out">
        <form action="JokesServlet" method="GET">
           <div class="txt">
               <h2 id="value" >${value}</h2>
            </div>
        </form>
    </div>
</div>
<button class="button" id="btn1" onclick="ajaxCall()">more jokes</button>

<script>
function ajaxCall() {
    $.ajax({
			url : '#',
			data : {
				refresh : true
			},
			success : function(responseText) {
				$('#value').text(responseText);
			}

		});   
}
</script>
<script>
     $(document).ready(function(){
        $(".button").click(function(){
            $(this).addClass("active");

            setTimeout(function(){
                $(".button").addClass("success");

            },1000);
            setTimeout(function(){
                $(".button").removeClass("active");
                $(".button").removeClass("success");
            },1000);
        });
    });
</script>

</body>
</html>