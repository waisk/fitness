/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var isLoginValid = true;
supplierPovOnlineId = "";
jQuery(document).ready(function ($) {
//   if(isLoginValid == true){
//        $('#invalidCredentials').modal();
//   }
//   
    if (sessionExpired == true) {
        $('#sessionExpired').modal();
    }

    if (isLoginValid == false) {
        $('#invalidCredentials').modal();
    }

});

function make_base_auth(user, password) {
    var tok = user + ':' + password;
    var hash = btoa(tok);
    return "Basic " + hash;
}

//function logIn(email, password){
//    
//    $("#email").val(email).change();
//    $("#password").val(password).change();
//    
//    $("#signInBtn").trigger( "click" );
//}

jQuery(document).ready(function ($) {

    $("#signInBtn").click(function (event) {
        event.preventDefault();
        var username = $("#username").val();
        var password = $("#password").val();

        var url = "/fitness/verifyLogin";

        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: url,
            beforeSend: function (xhr) {
                xhr.setRequestHeader('Authorization', make_base_auth(username, password));
            },
            timeout: 100000,
            async: false,
            cache: false,
            success: function (data) {
                $('#logInDropdown').css('display', 'none');
                $('#logOut').css('display', 'inline');
                window.location.href = data;
            },
            error: function (xhr, status, errorThrown) {
                console.log("ERROR: ", errorThrown);
                $('#invalidCredentials').modal();
            }
        });
    });


    $("#forgotUsername").on('keyup', function (event) {
        if ($("#forgotUsername").val() !== null && $("#forgotUsername").val() !== "") {
            $("#forgotPasswordBtn").prop("disabled", false);
        } else {
            $("#forgotPasswordBtn").prop("disabled", true);
        }

    });

    $("#forgotPasswordBtn").click(function (event) {
        event.preventDefault();
        var username = $("#forgotUsername").val();

        var jsonRequest = JSON.stringify({"username": username});

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/fitness/resetPassword/forgot",
            data: jsonRequest,
            success: function (data) {
                $('#forgotPasswordModal').modal('hide');
                $('#forgotPasswordSentModal').modal();
            },
            error: function (e) {
                console.log("ERROR: ", e);
                var response = e.responseJSON.message;
                if(response === "username does not exist"){
                    $('#usernameDoesNotExist').modal();
                }else{
                    $('#forgotPasswordModal').modal('hide');
                    $('#internalErrorModal').modal();
                }
            }
        });
    });
});