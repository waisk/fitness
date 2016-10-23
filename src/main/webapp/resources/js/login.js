/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var isLoginValid = true;
supplierPovOnlineId = "";
jQuery(document).ready(function($) {
//   if(isLoginValid == true){
//        $('#invalidCredentials').modal();
//   }
//   
   if(sessionExpired == true){
       $('#sessionExpired').modal();
   }
   
   if(isLoginValid == false){
       $('#invalidCredentials').modal();
   }
   
});

function make_base_auth(user, password) {
  var tok = user + ':' + password;
  var hash = btoa(tok);
  return "Basic " + hash;
}

jQuery(document).ready(function ($) {
    
    $("#signInBtn").click(function(event) {
        event.preventDefault();
        var username = $("#email").val();
        var password = $("#password").val();
        
        var url = "/fitness/verifyLogin";
        
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: url,
            beforeSend: function (xhr){ 
                xhr.setRequestHeader('Authorization', make_base_auth(username, password)); 
            },
            timeout: 100000,
            async: false,
            cache: false,
            success: function(data) {
                window.location.href = data;
            },
            error: function(xhr, status, errorThrown) {
                console.log("ERROR: ", errorThrown);
                $('#invalidCredentials').modal();
            }
        });
    });
    
    $("#forgotPasswordBtn").click(function (event) {
        event.preventDefault();
        var email = $("#forgot_email").val();

        var jsonRequest = JSON.stringify({"email": email});

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/fitness/forgotPassword",
            data: jsonRequest,
            success: function (data) {
                $('#forgotPasswordModal').modal('hide');
                $('#forgotPasswordSent').modal();
            },
            error: function (e) {
                console.log("ERROR: ", e);
                $('#forgotPasswordModal').modal('hide');
                $('#forgotPasswordErrorModal').modal();
            }
        });
    });
});
