<%--
  Created by IntelliJ IDEA.
  User: chenlongbo
  Date: 2017/4/12
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@include file="/commons/webpath.jsp"%>

<html>
<head>
    <script type="text/javascript">
        $(document).ready(function () {

            $("#aape").attr("href",idea.global.managerPath+"/helloworld/sayhi");

        });

    </script>
    <title>Title</title>
</head>
<body>

    <<a id="aape">aaaaaaaaaaaa</a>
</body>
</html>
