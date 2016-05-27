/**
 * Created by Administrator on 2016/5/25 0025.
 */
$(document).ready(function(){

    var pageSize = 8;

    addQuestion();

    setTop();

    //������ҵ
    addTask();

    //���ν���ҳ��
    enterQuestionPage(0,pageSize);


    $(".tcdPageCode").createPage({
        pageCount:getProblemSquarePageNum(pageSize),
        current:1,
        backFn:function(curPage){
            enterQuestionPage(curPage-1,8);
        }
    });

})

function loadQuestion(questionDTO){
    console.log(questionDTO);
    var temp = document.querySelector("#qTemplate");
    temp.content.querySelector("#qTitle").innerHTML  = questionDTO.question.questionTitle;
    temp.content.querySelector("#qTitle").href = "questionDetail.html?questionId="+ questionDTO.question.id;      //������ת����
    temp.content.querySelector("#questioner").innerHTML  = questionDTO.user.userName;
    temp.content.querySelector("#questionDescription").innerHTML  = questionDTO.question.questionDescription;
    temp.content.querySelector("#replyNumber").innerHTML  = questionDTO.question.replyNumber;
    temp.content.querySelector("#questionTime").innerHTML  = new Date(questionDTO.question.questionTime);
    document.querySelector("#qContainer").appendChild(temp.content.cloneNode(true)); //�ӽ�ȥ
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
                $("#qContainer").empty();
                var questionDTOList = msg.questionDTOList;
                questionDTOList.forEach(function(e){
                    loadQuestion(e);
                })
            }
            else{
                console.log("��ȡ����ʧ��!");
            }
        },error: function(msg){
            alert("���糬ʱ!");
        }
    });
}

function setTop(){

    var id = GetUrlParam("id");
    var problemSquare = null ;
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/problemSquareController/getProblemSquareById.do',
        async : false,
        data : {
            id:id
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
                problemSquare = msg.problemSquare;
            }
            else{
                console.log("������ҵʧ�ܣ�")
            }
        },error: function(msg){
            alert("���糬ʱ!");
        }
    });

    if(problemSquare){
        document.getElementById("qsPic").src = problemSquare.problemSquareIcon;
        document.getElementById("qsTitle").innerHTML = problemSquare.problemSquareName;
        document.getElementById("qsAttentionNum").innerHTML = problemSquare.attentionNum;
        document.getElementById("qsQuestionNum").innerHTML = problemSquare.messageNum;
        document.getElementById("qsDesc").innerHTML = problemSquare.problemSquareDescription;
    }
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
                    console.log("������ҵ�ɹ���")
                }
                else{
                    console.log("������ҵʧ�ܣ�")
                }
            },error: function(msg){
                alert("���糬ʱ!");
            }
        });
    });
}


function addQuestion(){

    $("#publishQuestionBtn").click(function (){
        console.log("��ʼ����");
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
                    console.log("���ʳɹ���");
                   $("#publishQuestionCancleBtn").click();
                }
                else{
                    console.log("����ʧ�ܣ�")
                }
            },error: function(msg){
                alert("���糬ʱ!");
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


function getProblemSquarePageNum(pageSize){
    var num = -1;
    var  problemSquareId = GetUrlParam("id");
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/questionController/getQuestionNumTotal.do',
        async : false,
        data : {
            pageSize:pageSize,
            problemSquareId:problemSquareId
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
                num = msg.pageTotal;
                console.log("num: "+num);
            }
            else{
                console.log("��ȡ��ҳ��ʧ�ܣ�");
            }
        },error: function(msg){

        }
    });
    return num;
}