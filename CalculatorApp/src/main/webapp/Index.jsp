<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator Menu</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
input {
    display: table-cell;
    vertical-align: middle
}
input[type='radio']{   
    margin: 10px;
 }

#date1{
	 display: none;
	 margin-left:10px;
	 margin-bottom: 10px;
}

#date2{
	display: none;
	margin-left:10px;
	margin-bottom: 10px;
}

#submitbtn{
	 display: none;
	 margin-left:10px;
	 margin-bottom: 10px;
}

#txtbox{
	 display: none;
	 margin-left:10px;
	 margin-bottom: 10px;
}


.inp{
	margin-top: 5px;
}


</style>
<script>

function  toggleMenu(){
	const radiobutton = document.querySelectorAll('input[type="radio"]');
	 let selectedValue;
	 for (const button of radiobutton) {
         if (button.checked) {
             selectedValue = button.value;
             break;
         }
     }

    var date1 = document.getElementById("date1");
    var date2 = document.getElementById("date2");
	var txtbox = document.getElementById("txtbox");
	var submitbtn = document.getElementById("submitbtn");

	submitbtn.style.display = "block";
	
    if(selectedValue==='1' ||selectedValue==='2'){
    	txtbox.style.display = "none";
		date1.style.display = "block";
		date2.style.display = "block";
	}
	else {
		date1.style.display= "block";
		date2.style.display = "none";
		txtbox.style.display = "block";
	}
}

function callCalculator(){
	 const radiobutton = document.querySelectorAll('input[type="radio"]');
	 let selectedValue;
	 for (const button of radiobutton) {
         if (button.checked) {
             selectedValue = button.value;
             break;
         }
     }
	 if(selectedValue==='1' ||selectedValue==='2'){
		 	if(selectedValue==='1')
		 		document.getElementById("form").action = '/addDates';
		 	else
		 		document.getElementById("form").action = '/subtractDates';
		}
	 else 
	 	 if(selectedValue==='3')
	 		document.getElementById("form").action = '/addNDays';
	 	 else if(selectedValue==='4')
	 		document.getElementById("form").action = '/subtractNDays';
		 else if(selectedValue==='5')
		 	document.getElementById("form").action = '/addNWeeks';
		 else if(selectedValue==='6')
		 	document.getElementById("form").action = '/subtractNWeeks';
		 else if(selectedValue==='7')	 
	 		document.getElementById("form").action = '/addNMontbs';
	 	 else if(selectedValue==='8')
	 		document.getElementById("form").action = '/subtractNMonths';
	 	 
}

</script>
</head>
<body>

	<form name="main" method="get" id="form">

		<div class="Option">
			<input type="radio" name="radioOption" value="1"/>
			<label>Add two dates</label>
		</div>	

		<div>
			<input type="radio" name="radioOption"  value="2"/ >
			<label>Subtract two dates</label>
		</div>
		
		<div>
			<input type="radio" name="radioOption"  value="3"/>
			<label>Add n days</label>
		</div>

		<div>
			<input type="radio" name="radioOption"  value="4"/>
			<label>Subtract n days</label>
		</div>

		<div>	
			<input type="radio" name="radioOption"  value="5"/>
			<label>Add n Weeks</label>
		</div>

		<div>
			<input type="radio" name="radioOption" value="6"/>
			<label>Subtract n Weeks</label>
		</div>	

		<div>
			<input type="radio" name="radioOption" value="7"/>
			<label>Add n months</label>
		</div>

		<div>
			<input type="radio" name="radioOption" value="8"/>
			<label>Subtract n months</label>
		</div>
		
		<input type="button" style="margin:10px" value="Next" onclick="toggleMenu()" class="btn btn-primary btn-md"> 

		<div id="date1">
			<div class="inp">
				<label>First Date</label>
			</div>
			<input type="date" name="date1" />
		</div>

		<div id="date2">
			<div class="inp">
				<label>Second Date</label>
			</div>
			<input type="date" name="date2"/>
		</div>

		<div id="txtbox">
			<div class="inp">
				<label>Value Of N</label>
			</div>
				<input type="text" name="n" placeholder="Value of N" />
		</div>

		<div id="submitbtn">
			<input type="submit"  class="btn btn-primary" onclick="callCalculator()" />
		</div>

	</form>	

</body>

</html>