/**
 * Created by Administrator on 2016/5/21 0021.
 */



$(document).ready(function(){

    //ע��
    $("#registerBtn").click(function() {

        console.log("����ע������");

        var loginName = document.getElementById("loginName").value;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var conformPassword = document.getElementById("password").value;
        if(password != conformPassword){
            alert("�����������벻һ�£�");
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
                    /* $("#SysHint").empty().append("<font color='red'>�û������������</font>");
                     document.getElementById("SysHint").style.display = "block";*/
                }
            },error: function(msg){
                alert("���糬ʱ!");
            }
        });
    });

})


