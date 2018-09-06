<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/10 0010
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>登录</title>

</head>
<body>
<div>
    <form action="/login" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" id="username" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" id="password" name="password"></td>
            </tr>
            <tr>
                <td><button type="submit">登录</button></td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript" src="../libs/js/jquery.js"></script>
<script type="text/javascript" src="../libs/js/language/cn.js"></script>
<script type="text/javascript" src="../libs/js/framework.js"></script>
</body>
</html>
