function results1(){
    console.log("here");
    var date1= new Date(document.getElementsById("date1_value").value);
    var date2= new Date(document.getElementsById("date2_value").value);
    var result;

    console.log(date1+' '+date2);

    document.getElementsByName("addDates").onClick = function(){
        result = (date1 + date2);
    }

    document.getElementsByName("subtractDates").onClick = function(){
        if(date1 > date2)
            result = date1-date2;
        else 
            result = date2 - date1;
    }
    console.log(result);

    document.write("Result is: "+ result);

}


function results2(){
    const date1= document.getElementsById("date1_value");
    const n = document.getElementById("n");

}