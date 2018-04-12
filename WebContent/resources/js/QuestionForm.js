/**
 * Javascript file for QuestionForm.jsp
 */

var counter=1;
		function addChoices(selected){
			 var qType = document.getElementById("questionType").value;
			 var p = document.getElementById("choices");
			 var newElement = document.createElement("input");
			 var label = document.createElement("label");
			 
			 var lable1 = document.getElementById("label1");
			if(qType == "chooseOne" || qType == "multiSelect"){
				if(counter == 1){
				 label.setAttribute("id", "label1");
				 label.innerHTML ="</br></br><label>Choice "+counter+ " " +"</label>";
				 newElement.setAttribute("type", "text");
				 newElement.setAttribute("id", counter);
				 newElement.setAttribute("name", counter);
				 newElement.setAttribute("onkeydown","newChoices(event)");
				 p.appendChild(label);
				 p.appendChild(newElement);
				 counter++
				}else if(counter > 1){
					for (var i =1; i <= counter; i++){
						var newElem = document.getElementById(i);
						newElem.parentNode.removeChild(newElem);
						label1.parentNode.removeChild(label1);
						counter--;
					}
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
					var newElem = document.getElementById(i);
					newElem.parentNode.removeChild(newElem);
					label1.parentNode.removeChild(label1);
					counter--;
					}
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
				counter = 1;
	}
		
		window.addEventListener('keydown', function(e) { //prevent form from submitting when enter key is pressed
	        if (e.keyIdentifier == 'U+000A' || e.keyIdentifier == 'Enter' || e.keyCode == 13) {
	            if (e.target.nodeName == 'INPUT' && e.target.type == 'text') {
	                e.preventDefault();
	                return false;
	            }
	        }
	    }, true);
