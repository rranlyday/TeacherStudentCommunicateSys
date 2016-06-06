/**
 * Created by Administrator on 2016/5/30 0030.
 */
$(document).ready(function(){

    $("#updatePasswordBtn").click(function(){

        var password = $("#password").val();
        var newPassword = $("#newPassword").val();
        var conformPassword = $("#conformPassword").val();

        if(password==null ||password===""){
            remindMessage("���������룡");
            return false;
        }
        if(newPassword != conformPassword){
            remindMessage("�������벻һ�£�");
            return false;
        }
        if(newPassword.length < 6){
            remindMessage("���볤��̫��");
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
                    remindMessage("��������ɹ�!");
                    $("#cancleUpdatePasswordBtn").click();  //�رնԻ���
            }
                else{
                    remindMessage(msg.message);
                }
            },error: function(msg){
                alert("�������");
            }
        });
    });
});

function remindMessage(message){
    document.getElementById("remindModalLabel").innerHTML = message ;
    $('#remindModalBtn').trigger("click");
}