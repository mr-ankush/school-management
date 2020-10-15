function orderAId()
{
    window.location="SearchAllStudentA";
}

function orderDId()
{
    window.location="SearchAllStudentD";
}

function orderAStd()
{
    window.location="SearchAllStudentA_Std";
}

function orderDStd()
{
    window.location="SearchAllStudentD_Std";
}

function orderAId_del()
{
    window.location="SearchAllDeletedA";
}

function orderDId_del()
{
    window.location="SearchAllDeletedD";
}

function orderAStd_del()
{
    window.location="SearchAllDeletedA_Std";
}

function orderDStd_del()
{
    window.location="SearchAllDeletedD_Std";
}

function eval()
{
    document.getElementById("txtCode").focus();
    var code = document.getElementById("txtCode").value;
    var code1 = document.getElementById("txtId1").value;
    var code2 = document.getElementById("txtId2").value;
    var code3 = document.getElementById("txtId3").value;
    var code4 = document.getElementById("txtId4").value;
    var value = code1*1000 + code2*100 + code3*10 + code4*1;
    var codelenght = document.getElementById("txtCode").value.length;
    document.getElementById("alert").innerHTML = "Captcha is for security porpose.";
    if(code==null)
    {
        document.getElementById("alert").innerHTML = "Fill Captcha-Code first.";
	return false;
    }
    else if(code=="")
    {
        document.getElementById("alert").innerHTML = "Fill Captcha-Code first.";
	return false;
    }
    else if(codelenght==4)
    {
        if(code==value)
        {
            document.getElementById("txtCode").blur();
            document.getElementById("alert").innerHTML = "Captcha is for security porpose.";
            return true;
        }
        else
        {
            document.getElementById("txtCode").value = null;
            document.getElementById("alert").innerHTML = "Invalid Captcha-Code.";
            return false;
        }
    }
    else
    {
        document.getElementById("txtCode").value = null;
        document.getElementById("alert").innerHTML = "Captcha-Code is wrong.";
        return false;
    }
    document.getElementById("txtCode").value = null;
    return false;
}
