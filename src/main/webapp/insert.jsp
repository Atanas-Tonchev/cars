
<head>
<title>Insert Details</title>
</head>
<body>
<div align="center">
        <table border="1" cell-padding="5">
        <caption><h2>List of users</h2></caption>
        <tr>
                        <th>ID</th>
                        <th>UsernameName</th>
                        <th>Password</th>

                    </tr>

                            </table>
                        </div>
<center>
    <h2>Fill in the details</h2>
    <form action="CarServlet" method="Post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="password"/></td>
            </tr>
            <tr />
        </table>
        <br /> <input type="submit" value="Insert Data" />
    </form>
     </center>
</body>

