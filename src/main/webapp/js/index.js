/**
 * Created by Administrator on 2016/5/21 0021.
 */

var user = null ;

$(document).ready(function(){

    //设置导航栏
    //setnav() ;

    //设置中间数据，动态加载
   // setMid();

    //进入页面时动态加载问题广场
    entryPage();

    $(".tcdPageCode").createPage({
        pageCount:6,
        current:1,
        backFn:function(p){
            console.log(p);
        }
    });

});

//设置导航栏
function setnav(){

    $("#userBtn").value = "欢迎，"+ user.username;

    if(user.usertype == 1){ //学生

    }else if(user.usertype == 2){  //老师

    }
}

//设置中间数据，动态加载
function setMid(problemSquareDto) {

    var template = document.querySelector('#qsTemplate');
    template.content.querySelector('#qsPic').src = problemSquareDto.problemSquare.problemSquareIcon;    //设置图标
    template.content.querySelector("#qsHeadline").value = problemSquareDto.problemSquare.problemSquareName;
    template.content.querySelector("#qsHeadline").href ="question.html?id="+problemSquareDto.problemSquare.id;
    template.content.querySelector("#qsDescription").value = problemSquareDto.problemSquare.problemSquareDescription;
    template.content.querySelector("#qsPeople").value = problemSquareDto.problemSquare.attentionNum;
    template.content.querySelector("#qsMessage").value = problemSquareDto.problemSquare.messageNum;
    template.content.querySelector("#qsAuthor").value = problemSquareDto.user.userName;
    template.content.querySelector("#qsTime").value = problemSquareDto.user.buildTime;

    document.querySelector('#qsContainer').appendChild(template.content.cloneNode(true)); //加进去
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
                    }); //循环处理
                }
            }
            else{
                console.log("获取失败！");
            }
        },error: function(msg){

        }
    });

}




