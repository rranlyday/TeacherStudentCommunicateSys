/**
 * Created by Administrator on 2016/5/17 0017.
 */
var code; // ��ȫ�� ������֤��
function createCode() {
    $("#identyCode").val("");
    // alert("++++++++++");
    code = "";
    var codeLength = 4;// ��֤��ĳ���
    var checkCode = document.getElementById("checkCode");
    var selectChar = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C',
        'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');// ���к�ѡ�����֤����ַ�����ȻҲ���������ĵ�

    for ( var i = 0; i < codeLength; i++) {
        var charIndex = Math.floor(Math.random() * 36);
        code += selectChar[charIndex];
    }

    if (checkCode) {
        checkCode.className = "code";
        checkCode.value = code;
    }
    ;
}

