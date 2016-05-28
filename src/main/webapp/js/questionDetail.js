/**
 * Created by Administrator on 2016/5/28 0028.
 */
$(document).ready(function(){
    setTop();

});



function getUrlParam(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)
        return  unescape(r[2]);
    return null;
}


function setTop(){
    var id = getUrlParam("id");
    var problemSquare = null ;
    var questionDTO = null ;
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/questionController/searchQuestionById.do',
        async : false,
        data : {
            id:id
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
                problemSquare = msg.problemSquare;
                questionDTO = msg.questionDTO;
            }
            else{
                console.log("发布作业失败！")
            }
        },error: function(msg){
            alert("网络超时!");
        }
    });
    if(problemSquare){
        document.getElementById("qsPic").src = problemSquare.problemSquareIcon;
        document.getElementById("qsTitle").innerHTML = problemSquare.problemSquareName;
        document.getElementById("qsAttentionNum").innerHTML = problemSquare.attentionNum;
        document.getElementById("qsQuestionNum").innerHTML = problemSquare.messageNum;
        document.getElementById("qsDesc").innerHTML = problemSquare.problemSquareDescription;
    }
    if(questionDTO){
        document.getElementById("#qTitle").innerHTML  = questionDTO.question.questionTitle;
        document.getElementById("#qTitle").href = "questionDetail.html?questionId="+ questionDTO.question.id;      //设置跳转链接
        document.getElementById("#questioner").innerHTML  = questionDTO.user.userName;
        document.getElementById("#questionDescription").innerHTML  = questionDTO.question.questionDescription;
        document.getElementById("#replyNumber").innerHTML  = questionDTO.question.replyNumber;
        var date = new Date(questionDTO.question.questionTime);
        document.getElementById("#questionTime").innerHTML  = getTimeStr(date);
    }
}
