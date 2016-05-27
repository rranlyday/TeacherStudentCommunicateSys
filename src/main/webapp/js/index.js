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
    template.content.querySelector("#qsHeadline").value = problemSquareDto.problemSquare.problemSquareName;
    template.content.querySelector("#qsHeadline").href ="question.html?id="+problemSquareDto.problemSquare.id;   //������ת����
    template.content.querySelector("#qsDescription").value = problemSquareDto.problemSquare.problemSquareDescription;
    template.content.querySelector("#qsPeople").value = problemSquareDto.problemSquare.attentionNum;
    template.content.querySelector("#qsMessage").value = problemSquareDto.problemSquare.messageNum;
    template.content.querySelector("#qsAuthor").value = problemSquareDto.user.userName;
    template.content.querySelector("#qsTime").value = problemSquareDto.user.buildTime;
    document.querySelector('#qsContainer').appendChild(template.content.cloneNode(true)); //�ӽ�ȥ
}

function entryPage(curPage,pageSize){
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/problemSquareController/getProblemSquare.do',
        async : false,
        data : {
            pageNum:curPage,
            pageSize:pageSize
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


function removeAllChild()
{
    var div = document.getElementById("#qsContainer");
    console.log(div);
    while(div.hasChildNodes()) //��div�»������ӽڵ�ʱ ѭ������
    {
        div.removeChild(div.firstChild);
    }
}



