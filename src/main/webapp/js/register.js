/**
 * Created by Administrator on 2016/5/21 0021.
 */



$(document).ready(function(){

    //注册
    $("#registerBtn").click(function() {

        console.log("进入注册流程");

        var loginName = document.getElementById("loginName").value;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var conformPassword = document.getElementById("password").value;
        if(password != conformPassword){
            alert("两次输入密码不一致！");
            return;
        }

        $.ajax({
            type : "post",
            contentType : "application/x-www-form-urlencoded;charset=UTF-8",
            url : '/userController/register.do',
            async : false,
            data : {
                loginName:loginName,
                username:username,
                password:password
            },
            dataType : 'json',
            success : function(msg) {
                if (msg.result == true){
                    window.location.href='../html/index.html';
                }
                else{
                    /* $("#SysHint").empty().append("<font color='red'>用户名或密码错误！</font>");
                     document.getElementById("SysHint").style.display = "block";*/
                }
            },error: function(msg){
                alert("网络超时!");
            }
        });
    });

})


