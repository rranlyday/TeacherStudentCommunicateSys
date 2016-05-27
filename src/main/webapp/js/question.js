/**
 * Created by Administrator on 2016/5/25 0025.
 */
$(document).ready(function(){

    addQuestion();

    //������ҵ
    addTask();

    //���ν���ҳ��
    enterQuestionPage(0,8);

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
                var questionDTOList = msg.questionDTOList;
                console.log(questionDTOList);
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
