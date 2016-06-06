/**
 * Created by Administrator on 2016/5/30 0030.
 */
$(document).ready(function(){

    $("#updatePasswordBtn").click(function(){

        var password = $("#password").val();
        var newPassword = $("#newPassword").val();
        var conformPassword = $("#conformPassword").val();

        if(password==null ||password===""){
            remindMessage("请输入密码！");
            return false;
        }
        if(newPassword != conformPassword){
            remindMessage("两次密码不一致！");
            return false;
        }
        if(newPassword.length < 6){
            remindMessage("密码长度太短");
            return false;
        }
        $.ajax({
            type : "post",
            contentType : "application/x-www-form-urlencoded;charset=UTF-8",
            url : '/userController/updatePassword.do',
            async : false,
            data :{
                password:password,
                newPassword:newPassword
            },
            dataType : 'json',
            success : function(msg) {
                if (msg.result == true){
                    remindMessage("更改密码成功!");
                    $("#cancleUpdatePasswordBtn").click();  //关闭对话框
            }
                else{
                    remindMessage(msg.message);
                }
            },error: function(msg){
                alert("网络错误！");
            }
        });
    });
});

function remindMessage(message){
    document.getElementById("remindModalLabel").innerHTML = message ;
    $('#remindModalBtn').trigger("click");
}