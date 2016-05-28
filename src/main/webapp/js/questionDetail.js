/**
 * Created by Administrator on 2016/5/28 0028.
 */
$(document).ready(function(){
    setTop();
    addReply();
    showReply(0,20);
});

function getUrlParam(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)
        return  unescape(r[2]);
    return null;
}

function setTop(){
    var id = getUrlParam("questionId");
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
                console.log("获取问题失败！")
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
        document.getElementById("qTitle").innerHTML  = questionDTO.question.questionTitle;
        document.getElementById("qTitle").href = "questionDetail.html?questionId="+ questionDTO.question.id;      //设置跳转链接
        document.getElementById("questioner").innerHTML  = questionDTO.user.userName;
        document.getElementById("questionDescription").innerHTML  = questionDTO.question.questionDescription;
        document.getElementById("replyNumber").innerHTML  = questionDTO.question.replyNumber;
        var date = new Date(questionDTO.question.questionTime);
        document.getElementById("questionTime").innerHTML  = getTimeStr(date);
    }
}

function showReply(curPage,pageSize){
    var questionReplyDTOList = null;
    var id = getUrlParam("questionId");
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/questionReplyController/searchByTime.do',
        async : false,
        data : {
            questionId:id,
            curPage:curPage,
            pageSize:pageSize
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
                questionReplyDTOList = msg.questionReplyDTOList;
            }
            else{
                console.log("发布作业失败！")
            }
        },error: function(msg){
            alert("网络超时!");
        }
    });

    if(questionReplyDTOList){
        questionReplyDTOList.forEach(function(questionReplyDTO,index){
            var template = document.querySelector("#replyTemplate");
            template.content.querySelector("#replyer").innerHTML  = questionReplyDTO.user.userName;
            template.content.querySelector("#replyerDesc").innerHTML  =questionReplyDTO.questionReply.replyDescription;
            template.content.querySelector("#replyTime").innerHTML  = getTimeStr(new Date(questionReplyDTO.questionReply.replyTime));
            template.content.querySelector("#replyNum").innerHTML  = questionReplyDTO.questionReply.replyNumber;
            template.content.querySelector("#proNum").innerHTML  = questionReplyDTO.questionReply.proNum;
            template.content.querySelector("#inverseNum").innerHTML  = questionReplyDTO.questionReply.inverseNum;
            var  commentContainer = template.content.querySelector(".commentContainer");
            commentContainer.innerHTML = "";                                   //清空评论
            commentContainer.id = questionReplyDTO.questionReply.id ;          //为修改埋下伏笔
            var  comment = showComment(questionReplyDTO.questionReply.id,0,8);
            if(comment){
                comment.forEach(function(replyQuestionReplyDTO,index){      //添加评论
                    var commentTemplate =  document.querySelector("#commentTemplate");
                    commentTemplate.content.querySelector("#commenter").innerHTML  = replyQuestionReplyDTO.user.userName;
                    commentTemplate.content.querySelector("#commentDesc").innerHTML  =replyQuestionReplyDTO.replyQuestionReply.replyDescription;
                    commentTemplate.content.querySelector("#commentTime").innerHTML  = getTimeStr(new Date(replyQuestionReplyDTO.replyQuestionReply.relpyTime));
                    commentTemplate.content.querySelector("#commentProNum").innerHTML  = replyQuestionReplyDTO.replyQuestionReply.replyProNum;
                    commentTemplate.content.querySelector("#commentInverseNum").innerHTML  = replyQuestionReplyDTO.replyQuestionReply.replyInverseNum;
                    commentContainer.appendChild(commentTemplate.content.cloneNode(true));
                });
            }
            document.querySelector("#replyContainer").appendChild(template.content.cloneNode(true));   //加进去
        });
    }
}

function showComment(replyId,curPage,pageSize){
    var comment = null;
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/replyQuestionReplyController/searchReplyQuestionReplyOrderByTime.do',
        async : false,
        data : {
            questionReplyId:replyId,
            curPage:curPage,
            pageSize:pageSize
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
                comment = msg.replyQuestionReplyDTOList;
            }
            else{
                console.log("获取评论失败！")
            }
        },error: function(msg){
            alert("网络超时!");
        }
    });
}
function getTimeStr(date){
    var year = date.getFullYear();
    var month = date.getMonth()+1;
    var day =  date.getDay();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();

    if(month<10)
        month = "0"+month;
    if(day<10)
        day = "0" +day ;
    if(hours < 10)
        hours = "0"+hours;
    if(minutes < 10)
        minutes = "0"+minutes;
    if(seconds < 10)
        seconds = "0"+seconds;
    return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds ;
}

function getDate(date){
    var year = date.getFullYear();
    var month = date.getMonth()+1;
    var day =  date.getDay();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();

    if(month<10)
        month = "0"+month;
    if(day<10)
        day = "0" +day ;
    return year+"-"+month+"-"+day ;
}

function addReply(){
    $("#replyInputBtn").click(function(){
        var reply = $("#replyInput").val();
        var  id = getUrlParam("questionId") ;

        $.ajax({
            type : "post",
            contentType : "application/x-www-form-urlencoded;charset=UTF-8",
            url : '/questionReplyController/addQuestionReply.do',
            async : false,
            data : {
                questionId:id,
                replyDescription:reply
            },
            dataType : 'json',
            success : function(msg) {
                if (msg.result == true){
                    console.log("回答成功！");
                }
                else{
                    console.log("回答失败！")
                }
            },error: function(msg){
                alert("网络超时!");
            }
        });
    });
}