/**
 * Created by Administrator on 2016/5/30 0030.
 */
$(document).ready(function(){

    $("#updatePasswordBtn").click(function(){

        var password = $("#password").val();
        var newPassword = $("#newPassword").val();
        var conformPassword = $("#conformPassword").val();

        if(password==null ||password===""){
            console.log("���������룡");
            return false;
        }
        if(newPassword != conformPassword){
            console.log("�������벻һ�£�")
            return false;
        }
        if(newPassword.length < 6){
            console.log("���볤��̫��");
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
                    console.log("��������ɹ���")
                    $("#cancleUpdatePasswordBtn").click();  //�رնԻ���
            }
                else{
                    console.log(msg.message);
                }
            },error: function(msg){
                console.log("�������");
            }
        });
    });
});