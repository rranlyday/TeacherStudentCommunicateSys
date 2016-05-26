/**
 * Created by Administrator on 2016/5/21 0021.
 */
jQuery(function () {
    $("#box").click(function () {
        return $("#filePic").click();
    });
});

function imagesSelected(files) {
    for (var i = 0, f; f = files[i]; i++) {
        var img = document.getElementById("userPic");
        img.onload = function(){
        }
        var reader = new FileReader();
        reader.onload = function(evt){img.src = evt.target.result;}
        reader.readAsDataURL(files[0]);
    }
}


function dropIt(e) {
    imagesSelected(e.dataTransfer.files);
    e.stopPropagation();
    e.preventDefault();
}