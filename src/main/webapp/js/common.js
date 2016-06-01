/**
 * Created by Administrator on 2016/5/23 0023.
 */

$(document).ready(function(){

    //判断是否登录
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
                user = msg.user ; //给全局对象user赋值
                setNav(user);    //设置导航栏
            }
            else{
                window.location.href='../html/login.html';  //回到登录页面让用户登录
            }
        },error: function(msg){

        }
    });


    //用户退出
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

    if(user.userType==1){ //学生
        var showPublishTaskBtn = document.getElementById("showPublishTaskBtn");
        if(showPublishTaskBtn)
            showPublishTaskBtn.class = "none";

        var showUploadMaterialBtn = document.getElementById("showUploadMaterialBtn");
        if(showUploadMaterialBtn)
            showUploadMaterialBtn.class = "none";
    }
    document.getElementById("userBtn").innerHTML = user.userName;
}

