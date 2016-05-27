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
                console.log("��ȡ����ʧ��!");
            }
        },error: function(msg){
            alert("���糬ʱ!");
        }
    });
}


function loadQuestion(questionDTO){
    var template = document.querySelector('#qTemplate');
    template.content.querySelector('#qTitle').src = questionDTO.question.questionTitle;
    template.content.querySelector('#qTitle').href ="questionDetail.html?questionId="+ questionDTO.question.id;      //������ת����
    template.content.querySelector('#questioner').src = questionDTO.user.userName;
    template.content.querySelector('#questionDescription').src = questionDTO.question.questionDescription;
    template.content.querySelector('#replyNumber').src = questionDTO.question.replyNumber;
    template.content.querySelector('#questionTime').src = questionDTO.question.questionTime;

    document.querySelector('#qContainer').appendChild(template.content.cloneNode(true)); //�ӽ�ȥ
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
                    console.log("���ʳɹ���")
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
