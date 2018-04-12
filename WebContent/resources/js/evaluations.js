/**
 * Javascript file for setting the dropdown options of createEvaluation and editEvaluation files
 */

//function to generate the options range for the year input box
//And load all instructor names into the first dropdown list
	window.onload=function(){
			for(var i=2018; i<=2020; i++){
    			var select = document.getElementById("year");
    			var option = document.createElement("OPTION");
    			select.options.add(option);
   			 	option.text = i;
    			option.value = i;
			}
				var xhttp;
				var item = "instructor";
				if (window.XMLHttpRequest){
					  xhttp=new XMLHttpRequest();
				  }
				else{
				  xhttp=new ActiveXObject("Microsoft.XMLHTTP");
				  }
				xhttp.onreadystatechange=function(){
				    if (xhttp.readyState == 4 && xhttp.status == 200) {
				    	if(xhttp.response == "<option value=\"\" selected='selected' >---Instructor Name---</option>"){
				    		window.alert("There are currently no instructors added.")
				    	}
				    document.getElementById("instrID").innerHTML = xhttp.responseText;
				    }
				};
				  xhttp.open("GET", "createEvaluation?item="+item , true);
				  xhttp.send();
		};
		
		function getCourse(instrID){
			if(instrID != ""){
				var xhttp;
				var item = "course";
				if (window.XMLHttpRequest){
					  xhttp=new XMLHttpRequest();
				  }
				else{
				  xhttp=new ActiveXObject("Microsoft.XMLHTTP");
				  }
				xhttp.onreadystatechange=function(){
				    if (xhttp.readyState == 4 && xhttp.status == 200) {
				    	if(xhttp.response == "<option value=\"\" selected='selected' >---Course Name---</option>"){
				    		window.alert("There are currently no courses assigned to this instructor.");
				    	}
				    document.getElementById("courseID").innerHTML = xhttp.responseText;
				    }
				};
				  xhttp.open("GET", "createEvaluation?item="+item +"&instrID="+instrID , true);
				  xhttp.send();
				}
		}
		
		function getYear(courseID){
			var instrID = document.getElementById("instrID").value;
			if(instrID != "" && courseID != ""){
				var xhttp;
				var item = "year";
				if (window.XMLHttpRequest){
					  xhttp=new XMLHttpRequest();
				  }
				else{
				  xhttp=new ActiveXObject("Microsoft.XMLHTTP");
				  }
				xhttp.onreadystatechange=function(){
				    if (xhttp.readyState == 4 && xhttp.status == 200) {
				    	if(xhttp.response == "<option value=\"\" selected='selected' >---Year---</option>"){
				    		window.alert("There are currently no evaluations for the selected instructor and course.");
				    	}
				    document.getElementById("year").innerHTML = xhttp.responseText;
				    }
				};
				  xhttp.open("GET", "createEvaluation?item="+item +"&instrID="+instrID+"&courseID="+courseID , true);
				  xhttp.send();
				}
		}
		
		function getTerm(year){
			var instrID = document.getElementById("instrID").value;
			var courseID = document.getElementById("courseID").value;
			if(instrID != ""){
				var xhttp;
				var item = "term";
				if (window.XMLHttpRequest){
					  xhttp=new XMLHttpRequest();
				  }
				else{
				  xhttp=new ActiveXObject("Microsoft.XMLHTTP");
				  }
				xhttp.onreadystatechange=function(){
				    if (xhttp.readyState == 4 && xhttp.status == 200) {
				    document.getElementById("term").innerHTML = xhttp.responseText;
				    }
				};
				  xhttp.open("GET", "createEvaluation?item="+item +"&instrID="+instrID+"&courseID="+courseID+"&year="+year , true);
				  xhttp.send();
				}
		}
		
		function confirmDelete(){
			var answer = confirm("Are you sure you want to delete this evaluation?");
			if(answer){
				return true;
			}
			else{
				return false;  
			}
		}