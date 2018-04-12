/**
 * Javascript for modifyEvaluation.jsp
 */


var counter=0;
		function addChoices(selected){ 
			for(var i = 1; document.getElementById(i) !== null; i++){
				counter = i;
			}
			var p = document.getElementById("choices");
			var newElement = document.createElement("input");
			var label = document.createElement("label");
			var lable1 = document.getElementById("label1");
			var qType = document.getElementById("questionType").value;
			if(qType == "chooseOne" || qType == "multiSelect"){
				if(counter == 0){ //first choice textbox option to create
				 label.setAttribute("id", "label1");
				 counter++;
				 label.innerHTML ="</br></br><label>Choice "+counter+ " " + "</label>";
				 newElement.setAttribute("type", "text");
				 newElement.setAttribute("id", counter);
				 newElement.setAttribute("name", counter);
				 newElement.setAttribute("onkeydown","newChoices(event)");
				 p.appendChild(label);
				 p.appendChild(newElement);
				 counter++;
				}else if(counter >= 1){ //When there are existing choice text boxes remove existing and add new one
					for (var i =1; i <= counter; i++){
						var newElem = document.getElementById(i)
						newElem.parentNode.removeChild(newElem);
						label1.parentNode.removeChild(label1);
					}
					 counter = 1;
					 label.setAttribute("id", "label1");
					 label.innerHTML ="</br></br><label>Choice "+counter+" </label>";
					 newElement.setAttribute("type", "text");
					 newElement.setAttribute("id", counter);
					 newElement.setAttribute("name", counter);
					 newElement.setAttribute("onkeydown","newChoices(event)");
					 p.appendChild(label);
					 p.appendChild(newElement);
					 counter++;
				}
			}else {
				for (var i =1; i <= counter; i++){
					var newElem = document.getElementById(i)
					newElem.parentNode.removeChild(newElem);
					label1.parentNode.removeChild(label1);
				}
				counter = 0;
			}
		}
		
		function newChoices(e){
			if(e.keyIdentifier == 'U+000A' || e.keyIdentifier == 'Enter' || e.keyCode == 13){
				if(document.getElementById(counter-1).value !== ""){
				var p = document.getElementById("choices");
				var newElement = document.createElement("input");
			 	var label = document.createElement("label");
			 	label.setAttribute("id", "label1");
				label.innerHTML ="</br></br><label>Choice "+counter+" </label>";
			 	newElement.setAttribute("type", "text");
				newElement.setAttribute("id", counter);
				newElement.setAttribute("name", counter);
			 	newElement.setAttribute("onkeydown","newChoices(event)");
			 	p.appendChild(label);
			 	p.appendChild(newElement);
			 	counter++;
			 
			}
		}
	}	
		
		function doReset(){
				for (var i =1; i <= counter; i++){
					var newElem = document.getElementById(i)
					var lable1 = document.getElementById("label1");
					newElem.parentNode.removeChild(newElem);
					label1.parentNode.removeChild(label1);
		}
				counter=1;
	}
		
		function confirmDelete(){
			var answer = confirm("Are you sure you want to delete this question?");
			if(answer)
				return true;
			else 
				return false;
			
		}
		
		window.addEventListener('keydown', function(e) {  //prevent the form from submitting when enter key is pressed
	        if (e.keyIdentifier == 'U+000A' || e.keyIdentifier == 'Enter' || e.keyCode == 13) {
	            if (e.target.nodeName == 'INPUT' && e.target.type == 'text') {
	                e.preventDefault();
	                return false;
	            }
	        }
	    }, true);
		