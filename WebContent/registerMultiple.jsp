<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Southeast Regional Credit Union Schools Web Portal</title>
        <script>
            function validateForm() {
                var x = document.forms["myForm"]["email"].value;
                var atpos = x.indexOf("@");
                var dotpos = x.lastIndexOf(".");
                if (atpos < 1 || dotpos, < atpos + 2 || dotpos + 2 >= x.length) {
                    alert("Not a valid e-mail address");
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <h1>Southeast Regional Credit Union Schools Web Portal</h1>
        <h1>Create Multiple Users</h1>
        <input type="file" id="fileUploadCSV" />
        <input type="button" value="Upload csv" id="btnUpload" />
        <table>
        <tr>
            <!--<td><input type="submit" name="submit" value="Register"></td>-->

        <td><a href="index.jsp">Go Back</a></td>
        </tr>
        </table>
        <form name="registration" action="register" method="post">
        <input type="submit" name="submit" value="Register">
            <table class="table" id="tblMultileads">
                <tr>
                    <th>Email</th>
                    <th>Password</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                </tr>
                <tbody id="tbodyLeads">
                </tbody>
            </table>
        </form>
            <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js">
            </script>
            <script>
                $(function() {
                    var csv = $("#fileUploadCSV").val();
                    $("#btnUpload").bind("click", function() {
                        debugger;
                        var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.csv|.txt)$/; //regex for Checking valid files csv of txt
                        if (regex.test($("#fileUploadCSV").val().toLowerCase())) {
                            if (typeof(FileReader) != "undefined") {
                                var reader = new FileReader();
                                reader.onload = function(e) {
                                    var rows = e.target.result.split("\r\n");
                                    if (rows.length > 0) {
                                        var first_Row_Cells = splitCSVtoCells(rows[0], ","); //Taking Headings
                                        if (first_Row_Cells.length != 5) {
                                            alert('Please upload a valid csv ,Colums count not matching ');
                                            return;
                                        }
                                        if (first_Row_Cells[0] != "email") {
                                            alert('Please upload a valid csv, Check Heading Email');
                                            return;
                                        }
                                        if (first_Row_Cells[1] != "password") {
                                            alert('Please upload a valid csv, Check Heading Password');
                                            return;
                                        }
                                        if (first_Row_Cells[2] != "fname") {
                                            alert('Please upload a valid csv, Check Heading First Name');
                                            return;
                                        }
                                        if (first_Row_Cells[3] != "lname") {
                                            alert('Please upload a valid csv, Check Heading Last Name');
                                            return;
                                        }
                                        if (first_Row_Cells[4] != "role") {
                                            alert('Please upload a valid csv, Check Heading Role');
                                            return;
                                        }
                                        var jsonArray = new Array();
                                        for (var i = 1; i < rows.length; i++) {
                                            var cells = splitCSVtoCells(rows[i], ",");
                                            var obj = {};
                                            for (var j = 0; j < cells.length; j++) {
                                                obj[first_Row_Cells[j]] = cells[j];
                                            }
                                            jsonArray.push(obj);
                                        }
                                        console.log(jsonArray);
                                        var html = "";
                                        for (i = 0; i < jsonArray.length; i++) {
                                            debugger;
                                            if (jsonArray[i].Name != "") {
                                                html += "<tr id=\"rowitem\"" + i + "><td style=\"display:none;\">" + i + "</td><td><input type=\"text\" name=\"email\" value=\"" + jsonArray[i].email + "\">  </input> </td>";
                                                html += "<td><input type=\"password\" name=\"password\" value= \"" + jsonArray[i].password + "\"></input></td>";
                                                html += "<td><input type=\"text\" name=\"fname\" value= \"" + jsonArray[i].fname + "\" ></input></td>";
                                                html += "<td><input type=\"text\" name=\"lname\" value= \"" + jsonArray[i].lname + "\" ></input></td>";
                                                html += "<td><input type=\"text\" name=\"role\" value= \"" + jsonArray[i].role + "\" ></input></td>";
                                            }
                                        }
                                        document.getElementById('tbodyLeads').innerHTML = html;
                                    }
                                }
                                reader.readAsText($("#fileUploadCSV")[0].files[0]);
                            } else {
                                alert("This browser does not support HTML5.");
                            }
                        } else {
                            alert("Select a valid CSV File.");
                        }
                    
                function splitCSVtoCells(row, separator) {
                    return row.split(separator);
                }
                
                    });
                });
            </script>
        </body>
    </html>