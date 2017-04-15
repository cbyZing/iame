<%--
  Created by IntelliJ IDEA.
  User: chenlongbo
  Date: 2017/4/12
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    //	String basePath = request.getScheme() + "://"
    //			+ request.getServerName() + ":" + request.getServerPort()
    //			+ path + "/";
    String basePath = path + "/";
%>

<script type="text/javascript" src="<%=basePath%>statics/jquery/jquery-3.2.1.js"></script>

<script type="text/javascript" language="Javascript">
    var idea = {};
    $.extend(idea, {
        global : {
            basePath : '<%=basePath %>',
            managerPath : '<%=basePath %>manager',
            clientPath : '<%=basePath %>client'
        }
    });
</script>