<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
        <style>
            td{
                padding: 10px;
            }
            div{
                width: 50%;
                border: 1px solid black;
                border-radius: 5px;
                background-color: aquamarine;
            }
        </style>
    </head>
    <body>
        <center>
            <h1>
                <u>Login Here</u>
            </h1>
        </center>
        <center>
            <div>
                <form action="Login" method="post">
                <table>
                    <tr>
                        <td>User name</td>
                        <td><input type="text" class="form-control" name="username" placeholder="User name"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" class="form-control" name="password" placeholder="Password"></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;"><input class="btn btn success" type="submit" value="Submit"></td>
                    </tr>
                </table>
                </form>
            </div>
        </center>
</body>