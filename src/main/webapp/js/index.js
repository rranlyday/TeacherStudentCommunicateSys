/**
 * Created by Administrator on 2016/5/21 0021.
 */

var user = null ;

$(document).ready(function(){

    //���õ�����
    //setnav() ;

    //�����м����ݣ���̬����
   // setMid();

    //����ҳ��ʱ��̬��������㳡
    entryPage();

    $(".tcdPageCode").createPage({
        pageCount:6,
        current:1,
        backFn:function(p){
            console.log(p);
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

//�����м����ݣ���̬����
function setMid(problemSquareDto) {

    var template = document.querySelector('#qsTemplate');
    template.content.querySelector('#qsPic').src = problemSquareDto.problemSquare.problemSquareIcon;    //����ͼ��
    template.content.querySelector("#qsHeadline").value = problemSquareDto.problemSquare.problemSquareName;
    template.content.querySelector("#qsHeadline").href ="question.html?id="+problemSquareDto.problemSquare.id;
    template.content.querySelector("#qsDescription").value = problemSquareDto.problemSquare.problemSquareDescription;
    template.content.querySelector("#qsPeople").value = problemSquareDto.problemSquare.attentionNum;
    template.content.querySelector("#qsMessage").value = problemSquareDto.problemSquare.messageNum;
    template.content.querySelector("#qsAuthor").value = problemSquareDto.user.userName;
    template.content.querySelector("#qsTime").value = problemSquareDto.user.buildTime;

    document.querySelector('#qsContainer').appendChild(template.content.cloneNode(true)); //�ӽ�ȥ
}



function entryPage(){
    $.ajax({
        type : "post",
        contentType : "application/x-www-form-urlencoded;charset=UTF-8",
        url : '/problemSquareController/getProblemSquare.do',
        async : false,
        data : {
            pageNum:0,
            pageSize:8
        },
        dataType : 'json',
        success : function(msg) {
            if (msg.result == true){
               var problemSquareDTOList = msg.problemSquareDTOList;
                console.log(problemSquareDTOList)
                if(problemSquareDTOList != null){
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




