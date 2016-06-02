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
                     $("#qsAttention").text("ȡ����ע");
                 }else{
                     $("#qsAttention").text("��ע");
                 }
             }
         },error: function(msg){
             alert("���糬ʱ!");
         }
     });

 })

function attention(a){

    var content = a.innerHTML;
    content = content.trim();

    var questionId = getUrlParam("questionId");
    var id = getUrlParam("id");

    if(content =="��ע"){
        a.innerHTML = "ȡ����ע";
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
                    remindMessage("��ע�ɹ���");
                }
                else{
                    remindMessage("��עʧ�ܣ������쳣���Ժ����ԣ�");
                }
            },error: function(msg){
                alert("���糬ʱ!");
            }
        });
    }else if(content =="ȡ����ע"){
        a.innerHTML = "��ע";
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
                    remindMessage("ȡ���ɹ���");
                }
                else{
                    remindMessage("ȡ��ʧ�ܣ������쳣���Ժ����ԣ�");
                }
            },error: function(msg){
                alert("���糬ʱ!");
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