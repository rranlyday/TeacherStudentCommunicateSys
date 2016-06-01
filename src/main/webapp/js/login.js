/**
 * Created by Administrator on 2016/5/21 0021.
 */

$(document).ready(function(){

    loginInfo();

    //登录
    $("#loginBtn").click(function (){
        var loginName = document.getElementById("loginName").value;
        var password = document.getElementById("password").value;
        var rememberPwd = false;
        if(document.getElementById("rememberPwd").checked){
            rememberPwd =true;
        }

        $.ajax({
            type : "post",
            contentType : "application/x-www-form-urlencoded;charset=UTF-8",
            url : '/userController/login.do',
            async : false,
            data : {
                loginName:loginName,
                password:password,
                rememberPwd:rememberPwd
            },
            dataType : 'json',
            success : function(msg) {
                if (msg.result == true){
                    window.location.href='../html/index.html';
                }else{
                    remindMessage("用户名或密码错误！");     //提醒
                }
            },error: function(msg){
                remindMessage("网络异常！");
            }
        });
    });


    //跳转至注册
    $("#registerBtn").click(function(){
        window.location.href='../html/register.html';
    });

});

function loginInfo(){

    var  loginName = null;
    var  password = null;

    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/userController/getLoginInfo.do',
        async : false,
        data : {
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
                loginName = msg.loginName;
                password = msg.password;
            }
        },error: function(msg){
            remindMessage("网络异常！");
        }
    });
    if(loginName !=null && loginName != "" && password !=null && password != ""){
        document.getElementById("loginName").value = loginName;
        document.getElementById("password").value = password;
        document.getElementById("rememberPwd").checked = true;
    }
}


function remindMessage(message){
    document.getElementById("remindModalLabel").innerHTML = message ;
    $('#remindModalBtn').trigger("click");
}

