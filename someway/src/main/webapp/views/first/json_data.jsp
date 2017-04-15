<%--
  Created by IntelliJ IDEA.
  User: chenlongbo
  Date: 2017/4/13
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/commons/webpath.jsp"%>
<html>
<head>

    <script type="text/javascript">
        $(document).ready(pageFiltration () {

                 $.ajax({
                     type: "POST",
                     url:idea.global.managerPath+"/helloworld/json",
                     async:false,
                    // data: {},
                     dataType: "json",
                     success: pageFiltration(result){
                         var userList = result.data;
                        if(result.success){
                            for(var i = 0; i < userList.length; i++){
                                $("#cloud").append(userList[i].id+"  -- account:"+userList[i].account+"  --name:"+userList[i].name);
                            }
                        }
                     }

                 });

        });

    </script>

    <title>get json</title>
</head>
<body>
    <div id="cloud"></div>
</body>
</html>
