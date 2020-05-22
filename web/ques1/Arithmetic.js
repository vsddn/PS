
function addition(){
    var num1 =Number(document.getElementById("firstNumber").value);
    var num2 = Number(document.getElementById("secondNumber").value);
    document.getElementById("result").innerHTML = num1+num2;
}
function subtraction(){
    var num1 =Number(document.getElementById("firstNumber").value);
    var num2 = Number(document.getElementById("secondNumber").value);
    document.getElementById("result").innerHTML = num1-num2;
}
function multiplication(){
    var num1 =Number(document.getElementById("firstNumber").value);
    var num2 = Number(document.getElementById("secondNumber").value);
    document.getElementById("result").innerHTML = num1*num2;
}
function division(){
    var num1 =Number(document.getElementById("firstNumber").value);
    var num2 = Number(document.getElementById("secondNumber").value);
    document.getElementById("result").innerHTML = num1/num2;
}
