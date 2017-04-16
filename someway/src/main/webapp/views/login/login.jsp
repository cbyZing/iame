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
    <title>登录</title>
</head>
<body>
<div class="demo form-bg" style="padding: 20px 0;">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <div id="loginForm" class="form-horizontal" >
                    <span class="heading">用户登录</span>
                    <div class="form-group">
                        <input type="text" name="username" v-model="username" class="form-control"  placeholder="用户名或电子邮件">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group help">
                        <input type="password" name="password" v-model="password" class="form-control"  placeholder="密　码">
                        <i class="fa fa-lock"></i>
                        <a href="#" class="fa fa-question-circle"></a>
                    </div>
                    <div class="form-group">
                        <div class="main-checkbox">
                            <input type="checkbox" value="None" id="checkbox1" name="check">
                            <label for="checkbox1"></label>
                        </div>
                        <span class="text">Remember me</span>
                        <button  type="submit" class="btn btn-default" @click="login">登录</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {

    });

    //登录
    function loginByForm() {
        /* var userVals = {};
         var account = $("#account").val();
         var pwd = $("#pwd").val();
         userVals.account = encodeURI(account);
         userVals.password = encodeURI(pwd);*/

        $("#loginForm").attr("action",idea.global.managerPath+"/home/login");
        $("#loginForm").submit();
    }

    var vm = new Vue({
        el:'#loginForm',
        data:{
            username: '',
            password: '',
            captcha: '',
            error: false,
            errorMsg: '',
            src: 'captcha.jpg'
        },
        beforeCreate: function(){
            if(self != top){
                top.location.href = self.location.href;
            }
        },
        methods: {
            // refreshCode: function(){
            //     this.src = "captcha.jpg?t=" + $.now();
            // },
            login: function (event) {
                var data = "username="+vm.username+"&password="+vm.password+"&captcha="+vm.captcha;
                $.ajax({
                    type: "POST",
                    url: idea.global.managerPath+"/home/login",
                    data: data,
                    dataType: "json",
                    success: function(result){
                        if(result.code == 0){//登录成功
                            parent.location.href ='/views/login/home.jsp';
                        }else{
                            vm.error = true;
                            vm.errorMsg = result.msg;

                            // vm.refreshCode();
                        }
                    }
                });
            }
        }
    });

</script>

</body>
</html>
