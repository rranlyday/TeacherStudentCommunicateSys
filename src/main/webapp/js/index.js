/**
 * Created by Administrator on 2016/5/21 0021.
 */

var user = null ;

$(document).ready(function(){

    var pageSize = 8 ;

    //���õ�����
    //setnav() ;

    //�����м����ݣ���̬����
   // setMid();



    //����ҳ��ʱ��̬��������㳡
    entryPage(0,pageSize);

    $(".tcdPageCode").createPage({
        pageCount:getProblemSquarePageNum(pageSize,null),
        current:1,
        backFn:function(curPage){
            entryPage(curPage-1,pageSize) ;
        }
    });

});

//���õ�����
function setnav(){

    $("#userBtn").value = "��ӭ��"+ user.username;

    if(user.usertype == 1){ //ѧ��

    }else if(user.usertype == 2){  //��ʦ

    }
}

function getProblemSquarePageNum(pageSize,condition){
    var num = -1;
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/problemSquareController/getProblemSquareTotal.do',
        async : false,
        data : {
            pageSize:pageSize,
            condition:condition
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


//�����м����ݣ���̬����
function setMid(problemSquareDto) {
    var template = document.querySelector('#qsTemplate');
    template.content.querySelector('#qsPic').src = problemSquareDto.problemSquare.problemSquareIcon;    //����ͼ��
    template.content.querySelector("#qsHeadline").innerHTML = problemSquareDto.problemSquare.problemSquareName;
    template.content.querySelector("#qsHeadline").href ="question.html?id="+problemSquareDto.problemSquare.id;   //������ת����
    template.content.querySelector("#qsDescription").innerHTML = problemSquareDto.problemSquare.problemSquareDescription;
    template.content.querySelector("#qsPeople").innerHTML = problemSquareDto.problemSquare.attentionNum;
    template.content.querySelector("#qsMessage").innerHTML = problemSquareDto.problemSquare.messageNum;
    template.content.querySelector("#qsAuthor").innerHTML = problemSquareDto.user.userName;
    var  date = new Date(problemSquareDto.problemSquare.buildTime);
    template.content.querySelector("#qsTime").innerHTML =  getTimeStr(date);
    document.querySelector('#qsContainer').appendChild(template.content.cloneNode(true)); //�ӽ�ȥ
}

function entryPage(curPage,pageSize,condition){
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/problemSquareController/getProblemSquare.do',
        async : false,
        data : {
            pageNum:curPage,
            pageSize:pageSize,
            condition:condition
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
               var problemSquareDTOList = msg.problemSquareDTOList;
                console.log(problemSquareDTOList)
                if(problemSquareDTOList != null){
                    $("#qsContainer").empty();
                    problemSquareDTOList.forEach(function(e){
                        setMid(e);
                    }); //ѭ������
                }
            }
            else{
                console.log("��ȡʧ�ܣ�");
            }
        },error: function(msg){

        }
    });
}


function removeAllChild() {
    var div = document.getElementById("#qsContainer");
    console.log(div);
    while(div.hasChildNodes())   //��div�»������ӽڵ�ʱ ѭ������
    {
        div.removeChild(div.firstChild);
    }
}

function getTimeStr(date){
    var year = date.getFullYear();
    var month = date.getMonth()+1;
    var day =  date.getDate();
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
    return year+"-"+month+"-"+day;
}


 function search(){
     var condition = $("#searchCondition").val();
     if(condition == null && condition ==""){
         remindMessage("�������������ݣ�");
     }else{
          //����ҳ��ʱ��̬��������㳡
         entryPage(0,8,condition);
     }
 }

function remindMessage(message){
    document.getElementById("remindModalLabel").innerHTML = message ;
    $('#remindModalBtn').trigger("click");
}

function create(){

        $("#materialForm").submit(function () {
            console.log("��ʼ�ϴ���");
            $("#materialForm").ajaxSubmit({
                type: "post",
                url: "/problemSquareController/build.do",
                success: function (msg) {
                    if(msg.result == true){
                        remindMessage("�½�����㳡�ɹ���")
                        $("#cancleUploadMaterialBtn").click();
                    }else{
                        remindMessage("�½�����㳡ʧ�ܣ�");
                    }
                },
                error: function (msg) {
                    alert("�����쳣!");
                }
            });
            return false;
        });
        $("#materialForm").submit();
}
