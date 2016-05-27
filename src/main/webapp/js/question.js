/**
 * Created by Administrator on 2016/5/25 0025.
 */
$(document).ready(function(){

    addQuestion();

    //发布作业
    addTask();

    //初次进入页面
    enterQuestionPage(0,8);

})

function f (){
    console.log("1111111111");
}
function enterQuestionPage(curPage,pageSize){

    var problemSquareId = GetUrlParam("id");

    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/questionController/searchQuestion.do',
        async : false,
        data : {
            problemSquareId:problemSquareId,
            curPage:curPage,
            pageSize:pageSize
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
                var questionDTOList = msg.questionDTOList;
                questionDTOList.forEach(function(questionDTO){
                    loadQuestion(questionDTO);
                })
            }
            else{
                console.log("获取数据失败!");
            }
        },error: function(msg){
            alert("网络超时!");
        }
    });
}


function loadQuestion(questionDTO){
    var template = document.querySelector('#qTemplate');
    template.content.querySelector('#qTitle').src = questionDTO.question.questionTitle;
    template.content.querySelector('#qTitle').href ="questionDetail.html?questionId="+ questionDTO.question.id;      //设置跳转链接
    template.content.querySelector('#questioner').src = questionDTO.user.userName;
    template.content.querySelector('#questionDescription').src = questionDTO.question.questionDescription;
    template.content.querySelector('#replyNumber').src = questionDTO.question.replyNumber;
    template.content.querySelector('#questionTime').src = questionDTO.question.questionTime;

    document.querySelector('#qContainer').appendChild(template.content.cloneNode(true)); //加进去
}


function addTask(){

    $("#publishTaskBtn").click(function(){
        var problemSquareId = GetUrlParam("id");
        var taskTitle = $("#taskTitle").val();
        var taskDecription = $("#taskDesc").val();

        $.ajax({
            type : "post",
            contentType : "application/x-www-form-urlencoded;charset=UTF-8",
            url : '/taskController/buildTask.do',
            async : false,
            data : {
                problemSquareId:problemSquareId,
                taskTitle:taskTitle,
                taskDecription:taskDecription
            },
            dataType : 'json',
            success : function(msg) {
                if (msg.result == true){
                    console.log("发布作业成功！")
                }
                else{
                    console.log("发布作业失败！")
                }
            },error: function(msg){
                alert("网络超时!");
            }
        });
    });
}


function addQuestion(){

    $("#publishQuestionBtn").click(function (){
        console.log("开始提问");
        var questionTitle = $("#publishQuestionTitle").val();
        var questionDescription = $("#publishQuestionDesc").val();
        var problemSquareId = GetUrlParam("id");

        $.ajax({
            type : "post",
            contentType : "application/x-www-form-urlencoded;charset=UTF-8",
            url : '/questionController/buildQuestion.do',
            async : false,
            data : {
                problemSquareId:problemSquareId,
                questionTitle:questionTitle,
                questionDescription:questionDescription
            },
            dataType : 'json',
            success : function(msg) {
                if (msg.result == true){
                    console.log("提问成功！")
                }
                else{
                    console.log("提问失败！")
                }
            },error: function(msg){
                alert("网络超时!");
            }
        });
    });
}



function GetUrlParam(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)
        return  unescape(r[2]);
    return null;
}
