/**
 * Created by Administrator on 2016/5/21 0021.
 */

var user = null ;

$(document).ready(function(){

    var pageSize = 8 ;

    //设置导航栏
    //setnav() ;

    //设置中间数据，动态加载
   // setMid();

    //进入页面时动态加载问题广场
    entryPage(0,pageSize);

    $(".tcdPageCode").createPage({
        pageCount:getProblemSquarePageNum(pageSize,null),
        current:1,
        backFn:function(curPage){
            entryPage(curPage-1,pageSize) ;
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
                console.log("获取总页数失败！");
            }
        },error: function(msg){

        }
    });
    return num;
}


//设置中间数据，动态加载
function setMid(problemSquareDto) {
    var template = document.querySelector('#qsTemplate');
    template.content.querySelector('#qsPic').src = problemSquareDto.problemSquare.problemSquareIcon;    //设置图标
    template.content.querySelector("#qsHeadline").innerHTML = problemSquareDto.problemSquare.problemSquareName;
    template.content.querySelector("#qsHeadline").href ="question.html?id="+problemSquareDto.problemSquare.id;   //设置跳转链接
    template.content.querySelector("#qsDescription").innerHTML = problemSquareDto.problemSquare.problemSquareDescription;
    template.content.querySelector("#qsPeople").innerHTML = problemSquareDto.problemSquare.attentionNum;
    template.content.querySelector("#qsMessage").innerHTML = problemSquareDto.problemSquare.messageNum;
    template.content.querySelector("#qsAuthor").innerHTML = problemSquareDto.user.userName;
    template.content.querySelector("#qsTime").innerHTML = new Date(problemSquareDto.problemSquare.buildTime);
    document.querySelector('#qsContainer').appendChild(template.content.cloneNode(true)); //加进去
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


function removeAllChild() {
    var div = document.getElementById("#qsContainer");
    console.log(div);
    while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
    {
        div.removeChild(div.firstChild);
    }
}



