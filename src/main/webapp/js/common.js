/**
 * Created by Administrator on 2016/5/23 0023.
 */

$(document).ready(function(){

    //�ж��Ƿ��¼
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/userController/userinfo.do',
        async : false,
        data : {
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
                user = msg.user ; //��ȫ�ֶ���user��ֵ
                setNav(user);    //���õ�����
            }
            else{
                window.location.href='../html/login.html';  //�ص���¼ҳ�����û���¼
            }
        },error: function(msg){

        }
    });


    //�û��˳�
    $("#loginOutBtn").click(function(){
        $.ajax({
            type : "get",
            contentType : "application/x-www-form-urlencoded;charset=UTF-8",
            url : '/userController/loginOut.do',
            async : false,
            dataType : 'json',
            success : function(msg) {
                if (msg.result == true){
                    window.location.href='html/login.html';
                }
                else{
                }
            },error: function(msg){

            }
        });
    });
});

function setNav(user){

    if(user.userType==1){ //ѧ��
        var showPublishTaskBtn = document.getElementById("showPublishTaskBtn");
        if(showPublishTaskBtn)
            showPublishTaskBtn.class = "none";

        var showUploadMaterialBtn = document.getElementById("showUploadMaterialBtn");
        if(showUploadMaterialBtn)
            showUploadMaterialBtn.class = "none";
    }
    document.getElementById("userBtn").innerHTML = user.userName;
}

