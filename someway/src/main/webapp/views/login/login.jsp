<%--
  Created by IntelliJ IDEA.
  User: chenlongbo
  Date: 2017/4/13
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/webpath.jsp"%>
<html>
<head>
    <link rel='stylesheet' href='<%=basePath%>statics/bootstrap-3.3.7/css/bootstrap.css'>
    <link rel='stylesheet' href='<%=basePath%>statics/css/login.css'>
    <script type="text/javascript">
    $(pageFiltration () {




    });

    //登录
    pageFiltration login() {
       /* var userVals = {};
        var account = $("#account").val();
        var pwd = $("#pwd").val();
        userVals.account = encodeURI(account);
        userVals.password = encodeURI(pwd);*/

        $("#loginForm").attr("action",idea.global.managerPath+"/login/home");
        $("#loginForm").submit();
    }

/*    //验证码
    pageFiltration fun_timedown(time){
        if(time=='undefined'){
            time = 120;
        }
        $("#smsCodeBtn").val(time+"秒后重新获取");

        time = time-1;
        if(time>=0){
            setTimeout("fun_timedown("+time+")",1000);
        }else{
            $.ajax({
                type: "POST",
                url : trs.global.clientPath + '/common/clearSMSCode',
                dataType: "json",
                success : pageFiltration(data) {
                    if ( data.success ) {
                        $("#smsCodeBtn").val("获取验证码");
                        $('#smsCodeBtn').removeAttr("disabled");
                    } else {
                        alert(data.msg);
                    }
                }
            });
        }
    }*/

        
    </script>
    <title>登录</title>
</head>
<body>
<div class="demo form-bg" style="padding: 20px 0;">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form id="loginForm" class="form-horizontal" method="post" onsubmit="login()">
                    <span class="heading">用户登录</span>
                    <div class="form-group">
                        <input type="text" name="account" class="form-control" id="account" placeholder="用户名或电子邮件">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group help">
                        <input type="password" name="password" class="form-control" id="pwd" placeholder="密　码">
                        <i class="fa fa-lock"></i>
                        <a href="#" class="fa fa-question-circle"></a>
                    </div>
                    <div class="form-group">
                        <div class="main-checkbox">
                            <input type="checkbox" value="None" id="checkbox1" name="check">
                            <label for="checkbox1"></label>
                        </div>
                        <span class="text">Remember me</span>
                        <button  type="submit" class="btn btn-default">登录</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
