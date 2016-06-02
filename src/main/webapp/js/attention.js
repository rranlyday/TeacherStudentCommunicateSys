/**
 * Created by Administrator on 2016/6/2 0002.
 */
 $(document).ready(function(){
     var questionId = getUrlParam("questionId");
     var id = getUrlParam("id");
     $.ajax({
         type : "post",
         contentType : "application/x-www-form-urlencoded;charset=UTF-8",
         url : '/problemSquareController/searchUserAttention.do',
         async : false,
         data : {
             problemSquareId:id,
             questionId:questionId
         },
         dataType : 'json',
         success : function(msg) {
             if (msg.result == true){
                 if(msg.att){
                     $("#qsAttention").text("取消关注");
                 }else{
                     $("#qsAttention").text("关注");
                 }
             }
         },error: function(msg){
             alert("网络超时!");
         }
     });

 })

function attention(a){

    var content = a.innerHTML;
    content = content.trim();

    var questionId = getUrlParam("questionId");
    var id = getUrlParam("id");

    if(content =="关注"){
        a.innerHTML = "取消关注";
        $.ajax({
            type : "post",
            contentType : "application/x-www-form-urlencoded;charset=UTF-8",
            url : '/problemSquareController/attentionProblemSquare.do',
            async : false,
            data : {
                problemSquareId:id,
                questionId:questionId
            },
            dataType : 'json',
            success : function(msg) {
                if (msg.result == true){
                    remindMessage("关注成功！");
                }
                else{
                    remindMessage("关注失败，网络异常请稍后再试！");
                }
            },error: function(msg){
                alert("网络超时!");
            }
        });
    }else if(content =="取消关注"){
        a.innerHTML = "关注";
        $.ajax({
            type : "post",
            contentType : "application/x-www-form-urlencoded;charset=UTF-8",
            url : '/problemSquareController/cancleAttentionProblemSquare.do',
            async : false,
            data : {
                problemSquareId:id,
                questionId:questionId
            },
            dataType : 'json',
            success : function(msg) {
                if (msg.result == true){
                    remindMessage("取消成功！");
                }
                else{
                    remindMessage("取消失败，网络异常请稍后再试！");
                }
            },error: function(msg){
                alert("网络超时!");
            }
        });
    }
}

function getUrlParam(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)
        return  unescape(r[2]);
    return null;
}

function remindMessage(message){
    document.getElementById("remindModalLabel").innerHTML = message ;
    $('#remindModalBtn').trigger("click");
}