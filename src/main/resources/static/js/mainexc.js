'use strict';
//signupForm
var singleUploadForm = document.querySelector('#singleUploadForm');
var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
var singleFileUploadError = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');

var multipleUploadForm = document.querySelector('#multipleUploadForm');
var multipleFileUploadInput = document.querySelector('#multipleFileUploadInput');
var multipleFileUploadError = document.querySelector('#multipleFileUploadError');
var multipleFileUploadSuccess = document.querySelector('#multipleFileUploadSuccess');

//var contextpath=$("#contextpath").text();

//alert(contextpath);

function uploadSingleFile(file) {
	$("#loader").show();
	
    var formData = new FormData();
    
	 if( file <1){
		 alert("please upload file");
	 }
	 
    formData.append("file", file);
	//alert(file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", contextpath+"/api/sendfile");
   // alert("successful");
    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = xhr.responseText;
        var message= xhr.responseText.message;
        
        var obj = JSON.parse(response);
        
        $("#loader").hide();
        
        if(xhr.status == 200) {
        	
        	
        	
            singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>"+obj.message + "</p>";
            singleFileUploadError.innerHTML = "<p>File Uploaded Successfully.</p><p>"+obj.message + "</p>";

            
            var tp;
            var title;
//alert(obj.status);
           if( obj.status=="00"){
        	   
               singleFileUploadSuccess.style.display = "block";
               singleFileUploadError.style.display = "none";

        	   
        	   tp="success"
        	   title="Successful"
        		   
           }else{
               singleFileUploadError.style.display = "block";
               singleFileUploadSuccess.style.display = "none";

        	   tp="danger"
               title="Failed"
            	   
           }
//            
//        	swal({   
//                title: title,   
//                text: obj.message,   
//                type: tp,   
//                showCancelButton: false,   
//                confirmButtonText: "Ok",   
//                closeOnConfirm: true 
//            }, function(){ 
           	 
            	

                //if( obj.status=="successful"){
             	  //alert("obj.ovaDataRecordInserted:: "+obj.ovaDataRecordNotInserted);
      				// location.reload();
                		var data=obj.ovaDataRecordInserted;
                		
                		var data2=obj.ovaDataRecordNotInserted;

                		
                	   $('#datatable').dataTable( {
                      	 // "scrollY": 500,
                      	   "order": [ 0, "desc" ],

                             "scrollX": true,
                             "processing": true, 
                             
                             "destroy":true,
                            
                             "pageLength": 10,
              
                             "aaData": data,
                          
                              dom: 'lBfrtip',
                             buttons: [
                                 'copy', 'csv', 'excel', 'pdf', 'print'
                             ], 
                             
                          
                             
                            "columns": [
                          	  
                           	  { "data": "account_identifier_type" },
                                 { "data": "account_identifier" },
                                { "data": "mobile" },
                                 { "data": "email" },
                                   { "data": "first_name" },
                                
                                
                                { "data": "last_name" },
          		 		
                                
                                { "data": "dob" 
                              	  
                                },
                                
                                 {"data": "social_identifier_type"},
                                   
                                   {"data": "social_identifier"},
                                
                                {"data": "role"},
                                
                                { "data": "branchName" },
                                
                                { "data": "status" },

                                { "data": "responseMsg" },

                                  

                            ]
                        ,
                           
          							  "columnDefs": [

          			                     ]

                        })
                        
                        
                        
                          $('#datatable2').dataTable( {
                      	 // "scrollY": 500,
                      	   "order": [ 0, "desc" ],

                             "scrollX": true,
                             "processing": true, 
                             
                             "destroy":true,
                            
                             "pageLength": 10,
              
                             "aaData": data2,
                          
                              dom: 'lBfrtip',
                             buttons: [
                                 'copy', 'csv', 'excel', 'pdf', 'print'
                             ], 
                             
                          
                             
                            "columns": [
                          	  
                           	  { "data": "account_identifier_type" },
                                 { "data": "account_identifier" },
                                { "data": "mobile" },
                                 { "data": "email" },
                                   { "data": "first_name" },
                                
                                
                                { "data": "last_name" },
          		 		
                                
                                { "data": "dob" 
                              	  
                                },
                                
                                 {"data": "social_identifier_type"},
                                   
                                   {"data": "social_identifier"},
                                
                                {"data": "role"},
                                
                                { "data": "branchName" },
                                
                                { "data": "status" },

                                   
                                { "data": "responseMsg" },

                            ]
                        ,
                           
          							  "columnDefs": [

          			                     ]

                        })
               // }
           	 
   			
           // });
        	
        } 
    }

    xhr.send(formData);
}

//function uploadMultipleFiles(files) {
//    var formData = new FormData();
//    for(var index = 0; index < files.length; index++) {
//        formData.append("files", files[index]);
//    }
//
//    var xhr = new XMLHttpRequest();
//    xhr.open("POST", "/uploadMultipleFiles");
//
//    xhr.onload = function() {
//        console.log(xhr.responseText);
//        var response = JSON.parse(xhr.responseText);
//        if(xhr.status == 200) {
//            multipleFileUploadError.style.display = "none";
//            var content = "<p>All Files Uploaded Successfully</p>";
//            for(var i = 0; i < response.length; i++) {
//                content += "<p>DownloadUrl : <a href='" + response[i].fileDownloadUri + "' target='_blank'>" + response[i].fileDownloadUri + "</a></p>";
//            }
//            multipleFileUploadSuccess.innerHTML = content;
//            multipleFileUploadSuccess.style.display = "block";
//        } else {
//            multipleFileUploadSuccess.style.display = "none";
//            multipleFileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
//        }
//    }
//
//    xhr.send(formData);
//}

singleUploadForm.addEventListener('submit', function(event){
    var files = singleFileUploadInput.files;
    if(files.length === 0) {
    	
    	
        singleFileUploadError.innerHTML = "Please select a file";
        singleFileUploadError.style.display = "block";
    }else{
    	
    	uploadSingleFile(files[0]);
    
    }
    event.preventDefault();
}, true);


//multipleUploadForm.addEventListener('submit', function(event){
//    var files = multipleFileUploadInput.files;
//    if(files.length === 0) {
//        multipleFileUploadError.innerHTML = "Please select at least one file";
//        multipleFileUploadError.style.display = "block";
//    }
//    uploadMultipleFiles(files);
//    event.preventDefault();
//}, true);

