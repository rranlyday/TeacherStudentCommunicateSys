/**
 * Created by Administrator on 2016/5/21 0021.
 */

$(document).ready(function(){

    //登录
    $("#loginBtn").click(function (){
        var loginName = document.getElementById("loginName").value;
        var password = document.getElementById("password").value;
        $.ajax({
            type : "post",
            contentType : "application/x-www-form-urlencoded;charset=UTF-8",
            url : '/userController/login.do',
            async : false,
            data : {
                loginName:loginName,
                password:password
            },
            dataType : 'json',
            success : function(msg) {
                if (msg.result == true){
                    window.location.href='../html/index.html';
                     //给全局对象user赋值
                }
                else{
                    $("#SysHint").empty().append("<font color='red'>用户名或密码错误！</font>");
                    document.getElementById("SysHint").style.display = "block";
                }
            },error: function(msg){
                alert("网络超时!");
            }
        });
    });


    //跳转至注册
    $("#registerBtn").click(function(){
        window.location.href='../html/register.html';
    });

});







