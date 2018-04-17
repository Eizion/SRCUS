/**
 * Javascript file for setting the dropdown options of createEvaluation and editEvaluation files
 */

//function to generate the options range for the year input box
//And load all instructor names into the first dropdown list
	window.onload=function(){
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
			    document.getElementById("year").innerHTML = xhttp.responseText;
			    }
			};
			  xhttp.open("GET", "selectEvaluation?item="+item, true);
			  xhttp.send();
		};
		
		function getInstructor(courseID){
			var year = document.getElementById("year").value;
			var term = document.getElementById("term").value;
			if(courseID != ""){
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
				    		window.alert("There are currently no instructors assigned to this course.");
				    	}
				    document.getElementById("instrID").innerHTML = xhttp.responseText;
				    }
				};
				  xhttp.open("GET", "selectEvaluation?item="+item +"&courseID="+courseID+"&year="+year+"&term="+term , true);
				  xhttp.send();
				}
		}
		
		function getCourse(term){
		var xhttp;
		var year = document.getElementById("year").value;
		var item = "course";
		if(term != null){
		if (window.XMLHttpRequest){
			  xhttp=new XMLHttpRequest();
		  }
		else{
		  xhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xhttp.onreadystatechange=function(){
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		    	if(xhttp.response == "<option value=\"\" selected='selected' >---Course Name---</option>"){
		    		window.alert("There are currently no courses assigned.")
		    	}
		    document.getElementById("courseID").innerHTML = xhttp.responseText;
		    }
		};
		  xhttp.open("GET", "selectEvaluation?item="+item +"&year="+year+"&term="+term , true);
		  xhttp.send();
		}
		
	}	
		
		
		
