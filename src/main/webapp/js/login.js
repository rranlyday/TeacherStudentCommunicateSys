/**
 * Created by Administrator on 2016/5/21 0021.
 */

$(document).ready(function(){

    //��¼
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
                     //��ȫ�ֶ���user��ֵ
                }
                else{
                    $("#SysHint").empty().append("<font color='red'>�û������������</font>");
                    document.getElementById("SysHint").style.display = "block";
                }
            },error: function(msg){
                alert("���糬ʱ!");
            }
        });
    });


    //��ת��ע��
    $("#registerBtn").click(function(){
        window.location.href='../html/register.html';
    });

});







