/**
 * Created by Administrator on 2016/5/25 0025.
 */
$(document).ready(function(){
    var pageSize = 8;

    addQuestion();

    setTop();

    //发布作业
    addTask();

    //初次进入页面
    enterQuestionPage(0,pageSize);

    showTask(0,5);

    showMaterial(0,5);

    $(".tcdPageCode").createPage({
        pageCount:getProblemSquarePageNum(pageSize),
        current:1,
        backFn:function(curPage){
            enterQuestionPage(curPage-1,8);
        }
    });

    $.jqPaginator('#taskPage', {
        totalPages: 5,
        visiblePages: 4,
        currentPage: 1,
        prev: '<li class="prev"><a href="javascript:;">《</a></li>',
        next: '<li class="next"><a href="javascript:;">》</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
        }
    });

    $.jqPaginator('#materialPage', {
        totalPages: 5,
        visiblePages: 4,
        currentPage: 1,
        prev: '<li class="prev"><a href="javascript:;">《</a></li>',
        next: '<li class="next"><a href="javascript:;">》</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange: function (num, type) {
        }
    });

})

function loadQuestion(questionDTO){
    var temp = document.querySelector("#qTemplate");
    temp.content.querySelector("#qTitle").innerHTML  = questionDTO.question.questionTitle;
    temp.content.querySelector("#qTitle").href = "questionDetail.html?questionId="+ questionDTO.question.id;      //设置跳转链接
    temp.content.querySelector("#questioner").innerHTML  = questionDTO.user.userName;
    temp.content.querySelector("#questionDescription").innerHTML  = questionDTO.question.questionDescription;
    temp.content.querySelector("#replyNumber").innerHTML  = questionDTO.question.replyNumber;
    var  date = new Date(questionDTO.question.questionTime);
    temp.content.querySelector("#questionTime").innerHTML  = getTimeStr(date);
    document.querySelector("#qContainer").appendChild(temp.content.cloneNode(true)); //加进去
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
                console.log("获取数据失败!");
            }
        },error: function(msg){
            alert("网络超时!");
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
                    console.log("提问成功！");
                   $("#publishQuestionCancleBtn").click();
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

function GetUrlParam(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)
        return  unescape(r[2]);
    return null;
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
                console.log("获取总页数失败！");
            }
        },error: function(msg){

        }
    });
    return num;
}


function showTask(taskCurPage,taskPagSize){

    var  problemSquareId = GetUrlParam("id");
    var taskList = null ;
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/taskController/searchTask.do',
        async : false,
        data :{
            curPage:taskCurPage,
            pageSize:taskPagSize,
            problemSquareId:problemSquareId
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
                taskList = msg.taskList;
            }
            else{
                console.log("获取作业失败！");
            }
        },error: function(msg){
            console.log("网络错误！");
        }
    });
    if(taskList){
        console.log(taskList);
       // $("#taskContainer").empty();
        taskList.forEach(function(task,index){
            var temp = document.querySelector("#taskTemplate");
            temp.content.querySelector("#tNo").innerHTML  = index+1;
            temp.content.querySelector("#tTitle").innerHTML  = task.taskTitle;
            temp.content.querySelector("#tDate").innerHTML  = getDate(new Date(task.pulishTime));
            document.querySelector("#taskContainer").appendChild(temp.content.cloneNode(true));   //加进去
        });
    }
}

function showMaterial(materialCurPage,materialPagSize){
    var  problemSquareId = GetUrlParam("id");
    var materialList = null ;
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/materialController/searchMaterial.do',
        async : false,
        data :{
            curPage:materialCurPage,
            pageSize:materialPagSize,
            problemSquareId:problemSquareId
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
                materialList = msg.materialList;
            }
            else{
                console.log("获取资料失败！");
            }
        },error: function(msg){
            console.log("网络错误！");
        }
    });
    if(materialList){
        console.log(materialList);
        materialList.forEach(function(material,index){
            var temp = document.querySelector("#materialTemplate");
            temp.content.querySelector("#mNo").innerHTML  = index+1;
            temp.content.querySelector("#mTitle").innerHTML  = material.taskTitle;
            temp.content.querySelector("#mDate").innerHTML  = getDate(new Date(material.uploadTime));
            document.querySelector("#materialContainer").appendChild(temp.content.cloneNode(true));   //加进去
        })
    }
}

